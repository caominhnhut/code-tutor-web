package com.gls.gs.persistent.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.common.collect.ComparisonChain;

@MappedSuperclass
public abstract class BaseTimestamp implements Serializable, Comparable<BaseTimestamp>
{
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, name = "timestamp_created")
	private Calendar timestampCreated;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, name = "timestamp_modified")
	private Calendar timestampModified;

	@PrePersist
	protected void onCreate()
	{
		timestampCreated = Calendar.getInstance();
		timestampModified = Calendar.getInstance();
	}

	@PreUpdate
	protected void onUpdate()
	{
		timestampModified = Calendar.getInstance();
	}

	public Calendar getTimestampCreated()
	{
		return timestampCreated;
	}

	public Calendar getTimestampModified()
	{
		return timestampModified;
	}

	@Override
	public int compareTo(BaseTimestamp o)
	{
		if (o == null || o.timestampCreated == null || o.timestampModified == null)
		{
			return -1;
		}

		return ComparisonChain.start()
				.compare(o.timestampCreated, timestampCreated)
				.compare(o.timestampModified, timestampModified)
				.result();
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}

		if (o == null || getClass() != o.getClass())
		{
			return false;
		}

		BaseTimestamp that = (BaseTimestamp) o;

		return Objects.equals(timestampCreated, that.timestampCreated) && Objects.equals(timestampModified, that.timestampModified);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(timestampCreated, timestampModified);
	}
}
