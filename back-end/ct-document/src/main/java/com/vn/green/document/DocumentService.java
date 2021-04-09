package com.vn.green.document;

import org.springframework.web.multipart.MultipartFile;

import com.vn.green.persistent.entity.DocumentEntity;

public interface DocumentService
{
    DocumentEntity store(MultipartFile file);

    DocumentEntity findById(Long id);
}
