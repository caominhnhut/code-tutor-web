package com.vn.green.core.mapper;

import com.vn.green.common.constant.BaseMapper;
import com.vn.green.common.dto.CourseDTO;
import com.vn.green.persistent.entity.CourseEntity;

import ma.glasnost.orika.MapperFacade;

public enum CourseMapper {

    INSTANCE;

    private final MapperFacade mapperFacade;

    CourseMapper() {

        BaseMapper.MAPPER_FACTORY.classMap(CourseEntity.class, CourseDTO.class).byDefault().toClassMap();
        BaseMapper.MAPPER_FACTORY.classMap(CourseDTO.class, CourseEntity.class).byDefault().toClassMap();

        mapperFacade = BaseMapper.MAPPER_FACTORY.getMapperFacade();
    }

    public CourseDTO mapFromEntity(CourseEntity courseEntity) {

        return mapperFacade.map(courseEntity, CourseDTO.class);
    }

    public CourseEntity mapToEntity(CourseDTO courseDTO) {

        return mapperFacade.map(courseDTO, CourseEntity.class);
    }
}
