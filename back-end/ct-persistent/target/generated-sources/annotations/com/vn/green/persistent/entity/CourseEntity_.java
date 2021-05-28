package com.vn.green.persistent.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CourseEntity.class)
public abstract class CourseEntity_ {

	public static volatile SingularAttribute<CourseEntity, String> courseName;
	public static volatile SingularAttribute<CourseEntity, Long> lesson;
	public static volatile SingularAttribute<CourseEntity, String> description;
	public static volatile SingularAttribute<CourseEntity, Long> id;
	public static volatile SingularAttribute<CourseEntity, String> iconUri;
	public static volatile SingularAttribute<CourseEntity, String> status;

	public static final String COURSE_NAME = "courseName";
	public static final String LESSON = "lesson";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String ICON_URI = "iconUri";
	public static final String STATUS = "status";

}

