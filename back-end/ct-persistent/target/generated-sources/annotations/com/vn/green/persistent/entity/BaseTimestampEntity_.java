package com.vn.green.persistent.entity;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BaseTimestampEntity.class)
public abstract class BaseTimestampEntity_ {

	public static volatile SingularAttribute<BaseTimestampEntity, Calendar> timestampModified;
	public static volatile SingularAttribute<BaseTimestampEntity, Calendar> timestampCreated;

	public static final String TIMESTAMP_MODIFIED = "timestampModified";
	public static final String TIMESTAMP_CREATED = "timestampCreated";

}

