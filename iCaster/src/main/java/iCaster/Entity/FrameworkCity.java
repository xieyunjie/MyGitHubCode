package iCaster.Entity;

import iCaster.Annotation.EntityL2Cache;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the framework_city database table.
 * 
 */
@Entity
@Table(name = "framework_city")
@Cacheable
@EntityL2Cache
@NamedQuery(name = "FrameworkCity.findAll", query = "SELECT f FROM FrameworkCity f")
public class FrameworkCity implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String name;

	public FrameworkCity()
	{
	}

	public String getUid()
	{
		return this.uid;
	}

	public void setUid(String uid)
	{
		this.uid = uid;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}