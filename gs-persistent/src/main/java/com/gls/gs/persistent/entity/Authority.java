package com.gls.gs.persistent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.gls.gs.common.enums.AuthorityName;

@Entity
@Table(name = "authority")
@SequenceGenerator(name = "role_seq", initialValue = 1)
public class Authority implements GrantedAuthority
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "name")
	private AuthorityName name;

	public void setName(AuthorityName name)
	{
		this.name = name;
	}

	@Override
	public String getAuthority()
	{
		return name.name();
	}

	public Long getId()
	{
		return id;
	}

	public AuthorityName getName()
	{
		return name;
	}

	public void setId(Long id)
	{
		this.id = id;
	}
}
