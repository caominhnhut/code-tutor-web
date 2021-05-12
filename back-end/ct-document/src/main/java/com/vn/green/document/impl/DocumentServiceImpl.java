package com.vn.green.document.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vn.green.document.DocumentService;
import com.vn.green.document.exception.FileStorageException;
import com.vn.green.persistent.entity.DocumentEntity;
import com.vn.green.persistent.repository.DocumentRepository;
import com.vn.green.validation.SupportType;
import com.vn.green.validation.ValidationException;
import com.vn.green.validation.Validator;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private List<Validator<?>> validators;

    @Value("${photo.path}")
    private String photoPath;

    @Value("${download.url}")
    private String downloadUrl;

    @Override
    public DocumentEntity storeImage(MultipartFile file) throws ValidationException {

        executeValidation(file);

        DocumentEntity documentEntity = new DocumentEntity();

        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        String uniqueFilename = uniqueFilename(filename);
        documentEntity.setFilename(uniqueFilename);

        documentEntity.setFileType(file.getContentType());
        documentEntity.setFileSize(file.getSize());

        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, Paths.get(String.format("%s\\%s", photoPath, uniqueFilename)), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new FileStorageException(String.format("Error while saving image: [%s]", e.getMessage()));
        }

        String fileUri = ServletUriComponentsBuilder.fromCurrentContextPath().path(downloadUrl).path(uniqueFilename).toUriString();
        fileUri = fileUri.replace("%3F", "?");
        documentEntity.setFileUri(fileUri);

        return documentRepository.create(documentEntity);
    }

    @Override
    public byte[] loadFileByName(String filename) throws IOException {
        return Files.readAllBytes(Paths.get(String.format("%s\\%s", photoPath, filename)));
    }

    private void executeValidation(MultipartFile multipartFile) throws ValidationException {

        for (Validator validator : validators) {
            if (validator.getSupportedTypes().contains(SupportType.DOCUMENT)) {
                validator.validate(multipartFile);
            }
        }
    }

    private String uniqueFilename(String filename) {

        Long timeInMillis = Calendar.getInstance().getTimeInMillis();

        return String.format("%s_%s", timeInMillis, filename);
    }
}
