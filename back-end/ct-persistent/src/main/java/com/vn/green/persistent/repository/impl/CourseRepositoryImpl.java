package com.vn.green.persistent.repository.impl;

import org.springframework.stereotype.Repository;

import com.vn.green.persistent.entity.CourseEntity;
import com.vn.green.persistent.repository.AbstractGenericDao;
import com.vn.green.persistent.repository.CourseRepository;

@Repository
public class CourseRepositoryImpl extends AbstractGenericDao<CourseEntity> implements CourseRepository {

}
