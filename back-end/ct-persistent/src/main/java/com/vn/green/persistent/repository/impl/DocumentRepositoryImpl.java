package com.vn.green.persistent.repository.impl;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.vn.green.persistent.entity.DocumentEntity;
import com.vn.green.persistent.repository.AbstractGenericDao;
import com.vn.green.persistent.repository.DocumentRepository;

@Repository
public class DocumentRepositoryImpl extends AbstractGenericDao<DocumentEntity> implements DocumentRepository
{
    @PostConstruct
    public void init()
    {
        super.setClazz(DocumentEntity.class);
    }
}
