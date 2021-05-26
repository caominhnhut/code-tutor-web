package com.vn.green.rest.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vn.green.common.dto.CourseDTO;
import com.vn.green.common.dto.LessonDTO;
import com.vn.green.core.service.CourseService;
import com.vn.green.core.service.LessonService;
import com.vn.green.course.models.Course;
import com.vn.green.course.models.Lesson;
import com.vn.green.rest.factory.mapper.CourseMapper;
import com.vn.green.rest.factory.mapper.JsonUtility;
import com.vn.green.rest.factory.mapper.LessonMapper;
import com.vn.green.validation.ValidationException;

@RestController()
public class CourseRestService {

    @Autowired
    private CourseService courseService;

    @Autowired
    private LessonService lessonService;

    @PostMapping(value = "/courses", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity createCourse(@RequestPart("course") String courseJson, @RequestPart(value = "file", required = false) MultipartFile file) {

        try {

            Course course = JsonUtility.convertFromJson(courseJson, Course.class);

            CourseDTO courseDTO = CourseMapper.INSTANCE.mapFromModel(course);

            Long courseId = courseService.createCourse(courseDTO, file);

            return ResponseEntity.status(HttpStatus.CREATED).body(courseId);

        } catch (ValidationException exception) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

    @PutMapping(value = "/courses/{course-id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity updateCourse(@PathVariable("course-id") Long courseId, @RequestPart("course") String courseJson, @RequestPart(value = "file", required = false) MultipartFile file) {

        try {

            Course course = JsonUtility.convertFromJson(courseJson, Course.class);

            CourseDTO courseDTO = CourseMapper.INSTANCE.mapFromModel(course);
            courseDTO.setId(courseId);

            courseService.updateCourse(courseDTO, file);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } catch (ValidationException exception) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

    @GetMapping(value = "/no-auth/courses")
    public ResponseEntity getCourses() {

        List<CourseDTO> courseDTOS = courseService.getCourses();

        List<Course> courses = courseDTOS.stream().map(CourseMapper.INSTANCE::mapFromDTO).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(courses);
    }

    @PostMapping(value = "/courses/{course-id}/lessons", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity createLesson(@PathVariable("course-id") long courseId, @RequestPart("lesson") String lessonJson, @RequestPart(value = "file", required = false) MultipartFile file) {

        try {

            Lesson lesson = JsonUtility.convertFromJson(lessonJson, Lesson.class);

            LessonDTO lessonDTO = LessonMapper.INSTANCE.mapFromModel(lesson);

            Long lessonId = lessonService.createLesson(lessonDTO, courseId, file);

            return ResponseEntity.status(HttpStatus.CREATED).body(lessonId);

        } catch (ValidationException exception) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

    @PutMapping(value = "/courses/{course-id}/lessons/{lesson-id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity updateLesson(@PathVariable("course-id") long courseId, @PathVariable("lesson-id") long lessonId, @RequestPart("lesson") String lessonJson, @RequestPart(value = "file", required = false) MultipartFile file) {

        try {

            Lesson lesson = JsonUtility.convertFromJson(lessonJson, Lesson.class);

            LessonDTO lessonDTO = LessonMapper.INSTANCE.mapFromModel(lesson);
            lessonDTO.setId(lessonId);

            lessonService.updateLesson(lessonDTO, courseId, file);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } catch (ValidationException exception) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

    @GetMapping(value = "/no-auth/courses/{course-id}/lessons")
    public ResponseEntity getLessons(@PathVariable("course-id") long courseId) {

        List<LessonDTO> lessonDTOS = lessonService.getLessons(courseId);
        if (lessonDTOS.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        List<Lesson> lessons = lessonDTOS.stream().map(LessonMapper.INSTANCE::mapFromDTO).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(lessons);
    }

    @GetMapping(value = "/no-auth/courses/{course-id}/lessons/{lesson-id}")
    public ResponseEntity getLessons(@PathVariable("course-id") long courseId, @PathVariable("lesson-id") long lessonId) {

        LessonDTO lessonDTO = lessonService.getLesson(courseId, lessonId);
        if (lessonDTO == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(LessonMapper.INSTANCE.mapFromDTO(lessonDTO));
    }
}
