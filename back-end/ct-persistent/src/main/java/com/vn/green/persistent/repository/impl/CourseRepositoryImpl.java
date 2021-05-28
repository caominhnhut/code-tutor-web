package com.vn.green.persistent.repository.impl;

import com.vn.green.persistent.entity.CourseEntity;
import com.vn.green.persistent.repository.AbstractGenericDao;
import com.vn.green.persistent.repository.CourseRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository("courseRepository")
@Transactional
public class CourseRepositoryImpl extends AbstractGenericDao<CourseEntity> implements CourseRepository {

    @Override
    public void createCourse(CourseEntity courseEntity) {
        em.persist(courseEntity);
    }
}
