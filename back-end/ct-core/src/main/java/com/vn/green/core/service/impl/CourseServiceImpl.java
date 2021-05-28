package com.vn.green.core.service.impl;

import com.vn.green.core.service.CourseService;
import com.vn.green.persistent.entity.CourseEntity;
import com.vn.green.persistent.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public void createCourse(CourseEntity courseEntity) {

        courseRepository.createCourse(courseEntity);
    }
}
