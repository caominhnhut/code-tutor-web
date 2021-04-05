package com.gls.gs.persistent.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FileEntity.class)
public abstract class FileEntity_ {

	public static volatile SingularAttribute<FileEntity, String> fileDownloadUri;
	public static volatile SingularAttribute<FileEntity, String> filename;
	public static volatile SingularAttribute<FileEntity, byte[]> data;
	public static volatile SingularAttribute<FileEntity, Long> id;
	public static volatile SingularAttribute<FileEntity, String> fileType;

}

