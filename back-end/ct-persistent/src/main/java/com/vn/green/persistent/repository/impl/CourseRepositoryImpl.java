package com.vn.green.persistent.repository.impl;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.vn.green.persistent.entity.CourseEntity;
import com.vn.green.persistent.repository.AbstractGenericDao;
import com.vn.green.persistent.repository.CourseRepository;

@Repository
public class CourseRepositoryImpl extends AbstractGenericDao<CourseEntity> implements CourseRepository {

    @PostConstruct
    public void init() {

        super.setClazz(CourseEntity.class);
    }
}
