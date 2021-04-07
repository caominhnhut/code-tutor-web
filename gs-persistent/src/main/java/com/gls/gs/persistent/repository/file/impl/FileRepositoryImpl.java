package com.gls.gs.persistent.repository.file.impl;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.gls.gs.persistent.entity.FileEntity;
import com.gls.gs.persistent.repository.file.FileRepository;
import com.gls.gs.persistent.repository.AbstractGenericDao;

@Repository
public class FileRepositoryImpl extends AbstractGenericDao<FileEntity> implements FileRepository
{
    @PostConstruct
    public void init()
    {
        super.setClazz(FileEntity.class);
    }
}
