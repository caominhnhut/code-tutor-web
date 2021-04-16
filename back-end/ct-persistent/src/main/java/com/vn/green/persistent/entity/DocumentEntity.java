package com.vn.green.persistent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "document")
@SequenceGenerator(name = "document_id_generator", sequenceName = "document_id_seq", allocationSize = 1)
public class DocumentEntity extends BaseTimestampEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_id_generator")
	private Long id;

	@Column(name = "file_name", unique = true)
	private String filename;

	@Column(name = "file_type")
	private String fileType;

	@Column(name = "download_uri")
	private String downloadUri;

	public DocumentEntity()
	{

	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getFilename()
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}

	public String getFileType()
	{
		return fileType;
	}

	public void setFileType(String fileType)
	{
		this.fileType = fileType;
	}

	public String getDownloadUri()
	{
		return downloadUri;
	}

	public void setDownloadUri(String downloadUri)
	{
		this.downloadUri = downloadUri;
	}
}