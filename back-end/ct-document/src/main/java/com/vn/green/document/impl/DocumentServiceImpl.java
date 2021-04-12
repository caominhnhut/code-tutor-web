package com.vn.green.document.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vn.green.document.DocumentService;
import com.vn.green.document.exception.FileStorageException;
import com.vn.green.persistent.entity.DocumentEntity;
import com.vn.green.persistent.repository.DocumentRepository;

@Service
public class DocumentServiceImpl implements DocumentService
{
    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public DocumentEntity store(MultipartFile file)
    {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());

        // Check if the file's name contains invalid characters
        if (filename.contains(".."))
        {
            throw new FileStorageException("Sorry! Filename contains invalid path sequence " + filename);
        }

        DocumentEntity documentEntity = new DocumentEntity();//new DocumentEntity(filename, file.getContentType(), file.getBytes());

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(documentEntity.getId().toString())
                .toUriString();

        documentEntity.setDownloadUri(fileDownloadUri);

        return documentRepository.create(documentEntity);
    }

    @Override
    public DocumentEntity findById(Long id)
    {
        return documentRepository.findOne(id);
    }
}
