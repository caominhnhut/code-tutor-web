package com.vn.green.rest.mapper;

import com.vn.green.courses.models.Course;
import com.vn.green.persistent.entity.CourseEntity;

import java.util.function.Function;

public class Mapper {

    private static Function<Course, CourseEntity> courseDTOToCourseEntity = courseDTO -> {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setCourseName(courseDTO.getName());
        courseEntity.setId(Long.parseLong(String.valueOf(courseDTO.getOrderId())));
        courseEntity.setDescription(courseDTO.getDescription());
        courseEntity.setLesson(Long.parseLong(String.valueOf(courseDTO.getAmountLesson())));
        courseEntity.setStatus(String.valueOf(courseDTO.getStatus()));
        courseEntity.setIconUri(courseDTO.getIconUri());
        return courseEntity;
    };

    public static CourseEntity from(Course courseDTO) {
        return courseDTOToCourseEntity.apply(courseDTO);
    }
}
