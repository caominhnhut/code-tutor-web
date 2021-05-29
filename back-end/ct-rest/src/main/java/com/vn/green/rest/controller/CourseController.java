package com.vn.green.rest.controller;

import com.vn.green.courses.models.Course;
import com.vn.green.core.service.CourseService;
import com.vn.green.persistent.entity.CourseEntity;
import com.vn.green.rest.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/no-auth/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping(value = "/create")
    public ResponseEntity<com.vn.green.courses.models.Course> courses(@RequestBody Course course) {
        System.out.println("Controller done this step ");
        CourseEntity courseEntity = Mapper.from(course);
        courseService.createCourse(courseEntity);

        return new ResponseEntity("hello bao linh", HttpStatus.OK);
    }
}
