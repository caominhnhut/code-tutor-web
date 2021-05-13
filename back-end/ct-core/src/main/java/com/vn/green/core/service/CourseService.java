package com.vn.green.core.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vn.green.common.dto.CourseDTO;
import com.vn.green.validation.ValidationException;

public interface CourseService {

    Long createCourse(CourseDTO courseDTO, MultipartFile file) throws ValidationException;

    boolean updateCourse(CourseDTO courseDTO, MultipartFile file) throws ValidationException;

    List<CourseDTO> getCourses();
}
