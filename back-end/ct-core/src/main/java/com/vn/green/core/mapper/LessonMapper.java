package com.vn.green.core.mapper;

import com.vn.green.common.constant.BaseMapper;
import com.vn.green.common.dto.LessonDTO;
import com.vn.green.common.dto.LessonMetaDataDTO;
import com.vn.green.persistent.entity.LessonEntity;

import ma.glasnost.orika.MapperFacade;

public enum LessonMapper {

    INSTANCE;

    private final MapperFacade mapperFacade;

    LessonMapper() {

        BaseMapper.MAPPER_FACTORY.classMap(LessonEntity.class, LessonDTO.class).byDefault().toClassMap();
        BaseMapper.MAPPER_FACTORY.classMap(LessonDTO.class, LessonEntity.class).byDefault().toClassMap();

        mapperFacade = BaseMapper.MAPPER_FACTORY.getMapperFacade();
    }

    public LessonDTO mapFromEntity(LessonEntity lessonEntity) {

        LessonDTO lessonDTO = mapperFacade.map(lessonEntity, LessonDTO.class);

        LessonMetaDataDTO lessonMetaDataDTO = new LessonMetaDataDTO();
        lessonMetaDataDTO.setCourse(lessonEntity.getCourse().getName());
        lessonMetaDataDTO.setCreatedBy(lessonEntity.getCreatedBy());
        lessonMetaDataDTO.setCreatedDate(lessonEntity.getTimestampCreated());
        lessonDTO.setMetaData(lessonMetaDataDTO);

        return lessonDTO;
    }

    public LessonEntity mapToEntity(LessonDTO lessonDTO) {

        return mapperFacade.map(lessonDTO, LessonEntity.class);
    }
}
