package com.gls.gs.file.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gls.gs.file.FileService;
import com.gls.gs.file.exception.FileStorageException;
import com.gls.gs.persistent.entity.FileEntity;
import com.gls.gs.persistent.repository.file.FileRepository;

@Service
public class FileServiceImpl implements FileService
{
    @Autowired
    private FileRepository fileRepository;

    @Override
    public FileEntity store(MultipartFile file)
    {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());

        try
        {
            // Check if the file's name contains invalid characters
            if (filename.contains(".."))
            {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + filename);
            }

            FileEntity fileEntity = new FileEntity(filename, file.getContentType(), file.getBytes());

            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(fileEntity.getId().toString())
                    .toUriString();

            fileEntity.setFileDownloadUri(fileDownloadUri);

            return fileRepository.create(fileEntity);
        }
        catch (IOException ex)
        {
            throw new FileStorageException("Could not store file " + filename + ". Please try again!", ex);
        }
    }

    @Override
    public FileEntity findById(Long id)
    {
        return fileRepository.findOne(id);
    }
}
