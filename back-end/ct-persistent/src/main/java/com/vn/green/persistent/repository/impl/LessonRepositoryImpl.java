package com.vn.green.persistent.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.vn.green.persistent.entity.CourseEntity_;
import com.vn.green.persistent.entity.LessonEntity;
import com.vn.green.persistent.entity.LessonEntity_;
import com.vn.green.persistent.repository.AbstractGenericDao;
import com.vn.green.persistent.repository.LessonRepository;

@Repository
public class LessonRepositoryImpl extends AbstractGenericDao<LessonEntity> implements LessonRepository {

    @PostConstruct
    public void init() {

        super.setClazz(LessonEntity.class);
    }

    @Override
    public Optional<LessonEntity> findByLessonIdAndCourse(long lessonId, long courseId) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<LessonEntity> cq = cb.createQuery(LessonEntity.class);
        Root<LessonEntity> root = cq.from(LessonEntity.class);
        cq.select(root);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(root.get(LessonEntity_.ID), lessonId));
        predicates.add(cb.equal(root.get(LessonEntity_.course).get(CourseEntity_.ID), courseId));
        cq.where(cb.and(predicates.toArray(new Predicate[]{})));

        TypedQuery<LessonEntity> query = em.createQuery(cq);
        List<LessonEntity> lessonEntities = query.getResultList();
        if (lessonEntities == null || lessonEntities.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(lessonEntities.get(0));
    }
}
