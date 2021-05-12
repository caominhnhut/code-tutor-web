package com.vn.green.document;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.vn.green.persistent.entity.DocumentEntity;
import com.vn.green.validation.ValidationException;

public interface DocumentService
{
    DocumentEntity storeImage(MultipartFile file) throws ValidationException;

    byte[] loadFileByName(String filename) throws IOException;
}
