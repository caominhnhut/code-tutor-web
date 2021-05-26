package com.vn.green.persistent.repository;

import java.util.List;
import java.util.Optional;

import com.vn.green.persistent.entity.LessonEntity;

public interface LessonRepository extends GenericDao<LessonEntity> {

    Optional<LessonEntity> findByLessonIdAndCourse(long lessonId, long courseId);

    Optional<List<LessonEntity>> findLessonsByCourse(long courseId);

}
