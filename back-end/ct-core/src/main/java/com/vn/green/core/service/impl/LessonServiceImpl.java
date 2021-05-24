package com.vn.green.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vn.green.common.dto.LessonDTO;
import com.vn.green.core.service.LessonService;
import com.vn.green.persistent.repository.LessonRepository;
import com.vn.green.validation.ValidationException;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public Long createLesson(LessonDTO lessonDTO, long courseId, MultipartFile file) throws ValidationException {

        return null;
    }

    @Override
    public boolean updateLesson(LessonDTO lessonDTO, MultipartFile file) throws ValidationException {

        return false;
    }

    @Override
    public List<LessonDTO> getLessons() {

        return null;
    }

    @Override
    public List<LessonDTO> getLesson(Long id) {

        return null;
    }
}
