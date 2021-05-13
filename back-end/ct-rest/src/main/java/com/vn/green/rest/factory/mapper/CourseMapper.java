package com.vn.green.rest.factory.mapper;

import com.vn.green.common.constant.BaseMapper;
import com.vn.green.common.dto.CourseDTO;
import com.vn.green.course.models.Course;

import ma.glasnost.orika.MapperFacade;

public enum CourseMapper {

    INSTANCE;

    private final MapperFacade mapperFacade;

    CourseMapper() {

        BaseMapper.MAPPER_FACTORY.classMap(Course.class, CourseDTO.class).byDefault().toClassMap();
        BaseMapper.MAPPER_FACTORY.classMap(CourseDTO.class, Course.class).byDefault().toClassMap();

        mapperFacade = BaseMapper.MAPPER_FACTORY.getMapperFacade();
    }

    public CourseDTO mapFromModel(Course course) {

        return mapperFacade.map(course, CourseDTO.class);
    }

    public Course mapFromDTO(CourseDTO courseDTO) {

        return mapperFacade.map(courseDTO, Course.class);
    }
}
