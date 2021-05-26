package com.vn.green.rest.factory.mapper;

import com.vn.green.common.constant.BaseMapper;
import com.vn.green.common.dto.LessonDTO;
import com.vn.green.course.models.Lesson;

import ma.glasnost.orika.MapperFacade;

public enum LessonMapper {

    INSTANCE;

    private final MapperFacade mapperFacade;

    LessonMapper() {

        BaseMapper.MAPPER_FACTORY.classMap(Lesson.class, LessonDTO.class).byDefault().toClassMap();
        BaseMapper.MAPPER_FACTORY.classMap(LessonDTO.class, Lesson.class).byDefault().toClassMap();

        mapperFacade = BaseMapper.MAPPER_FACTORY.getMapperFacade();
    }

    public LessonDTO mapFromModel(Lesson lesson) {

        return mapperFacade.map(lesson, LessonDTO.class);
    }

    public Lesson mapFromDTO(LessonDTO lessonDTO) {

        return mapperFacade.map(lessonDTO, Lesson.class);
    }
}
