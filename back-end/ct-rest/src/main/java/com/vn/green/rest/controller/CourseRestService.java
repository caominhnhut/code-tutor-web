package com.vn.green.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vn.green.common.dto.CourseDTO;
import com.vn.green.core.service.CourseService;
import com.vn.green.course.models.Course;
import com.vn.green.rest.factory.mapper.CourseMapper;
import com.vn.green.validation.ValidationException;

@RestController()
public class CourseRestService {

    @Autowired
    private CourseService courseService;

    @PostMapping(value = "/courses", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity createCourse(@RequestPart("course") String courseJson, @RequestPart(value = "file", required = false) MultipartFile file) {

        try {

            Course course = convertFromJson(courseJson);

            CourseDTO courseDTO = CourseMapper.INSTANCE.mapFromModel(course);

            Long courseId = courseService.createCourse(courseDTO, file);

            return new ResponseEntity(courseId, HttpStatus.CREATED);

        } catch (ValidationException exception) {

            return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Course convertFromJson(String json) throws ValidationException {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, Course.class);
        } catch (JsonProcessingException e) {
            throw new ValidationException("The data of course is incorrect format");
        }
    }
}
