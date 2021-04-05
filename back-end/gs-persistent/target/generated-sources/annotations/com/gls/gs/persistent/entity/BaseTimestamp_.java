package com.gls.gs.persistent.entity;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BaseTimestamp.class)
public abstract class BaseTimestamp_ {

	public static volatile SingularAttribute<BaseTimestamp, Calendar> timestampModified;
	public static volatile SingularAttribute<BaseTimestamp, Calendar> timestampCreated;

}

