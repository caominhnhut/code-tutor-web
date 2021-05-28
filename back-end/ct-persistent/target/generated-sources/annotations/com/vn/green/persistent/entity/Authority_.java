package com.vn.green.persistent.entity;

import com.vn.green.common.enums.AuthorityName;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Authority.class)
public abstract class Authority_ extends com.vn.green.persistent.entity.BaseTimestampEntity_ {

	public static volatile SingularAttribute<Authority, AuthorityName> name;
	public static volatile SingularAttribute<Authority, Long> id;

	public static final String NAME = "name";
	public static final String ID = "id";

}

