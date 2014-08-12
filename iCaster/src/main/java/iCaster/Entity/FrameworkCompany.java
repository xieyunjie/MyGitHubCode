package iCaster.Entity;

import iCaster.Annotation.EntityL2Cache;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the framework_company database table.
 * 
 */
@Entity
@Table(name = "framework_company")
@Cacheable
@EntityL2Cache(true)
@NamedQuery(name = "FrameworkCompany.findAll", query = "SELECT f FROM FrameworkCompany f")
public class FrameworkCompany implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String cityUID;

	private String name;

	public FrameworkCompany()
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

	public String getCityUID()
	{
		return this.cityUID;
	}

	public void setCityUID(String cityUID)
	{
		this.cityUID = cityUID;
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