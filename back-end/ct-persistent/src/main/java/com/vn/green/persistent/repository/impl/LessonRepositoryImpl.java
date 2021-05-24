package com.vn.green.persistent.repository.impl;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.vn.green.persistent.entity.LessonEntity;
import com.vn.green.persistent.repository.AbstractGenericDao;
import com.vn.green.persistent.repository.LessonRepository;

@Repository
public class LessonRepositoryImpl extends AbstractGenericDao<LessonEntity> implements LessonRepository {

    @PostConstruct
    public void init() {

        super.setClazz(LessonEntity.class);
    }
}
