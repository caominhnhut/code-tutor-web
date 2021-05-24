package com.vn.green.core.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vn.green.common.dto.LessonDTO;
import com.vn.green.validation.ValidationException;

public interface LessonService {

    Long createLesson(LessonDTO lessonDTO, long courseId, MultipartFile file) throws ValidationException;

    boolean updateLesson(LessonDTO lessonDTO, MultipartFile file) throws ValidationException;

    List<LessonDTO> getLessons();

    List<LessonDTO> getLesson(Long id);
}
