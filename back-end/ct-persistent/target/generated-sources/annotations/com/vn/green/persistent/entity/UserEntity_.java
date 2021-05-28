package com.vn.green.persistent.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserEntity.class)
public abstract class UserEntity_ extends com.vn.green.persistent.entity.BaseTimestampEntity_ {

	public static volatile SingularAttribute<UserEntity, String> password;
	public static volatile SingularAttribute<UserEntity, String> description;
	public static volatile SingularAttribute<UserEntity, Long> id;
	public static volatile SingularAttribute<UserEntity, String> email;
	public static volatile ListAttribute<UserEntity, Authority> authorities;

	public static final String PASSWORD = "password";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String EMAIL = "email";
	public static final String AUTHORITIES = "authorities";

}

