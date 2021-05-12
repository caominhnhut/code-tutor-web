package com.vn.green.core.service;

import org.springframework.web.multipart.MultipartFile;

import com.vn.green.common.dto.CourseDTO;
import com.vn.green.validation.ValidationException;

public interface CourseService {

    Long createCourse(CourseDTO courseDTO, MultipartFile file) throws ValidationException;
}
