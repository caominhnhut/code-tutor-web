package com.gls.gs.file;

import org.springframework.web.multipart.MultipartFile;

import com.gls.gs.persistent.entity.FileEntity;

public interface FileService
{
    FileEntity store(MultipartFile file);

    FileEntity findById(Long id);
}
