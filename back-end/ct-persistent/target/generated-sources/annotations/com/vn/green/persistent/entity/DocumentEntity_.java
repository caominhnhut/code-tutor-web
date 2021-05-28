package com.vn.green.persistent.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DocumentEntity.class)
public abstract class DocumentEntity_ extends com.vn.green.persistent.entity.BaseTimestampEntity_ {

	public static volatile SingularAttribute<DocumentEntity, String> filename;
	public static volatile SingularAttribute<DocumentEntity, Long> id;
	public static volatile SingularAttribute<DocumentEntity, String> downloadUri;
	public static volatile SingularAttribute<DocumentEntity, String> fileType;

	public static final String FILENAME = "filename";
	public static final String ID = "id";
	public static final String DOWNLOAD_URI = "downloadUri";
	public static final String FILE_TYPE = "fileType";

}

