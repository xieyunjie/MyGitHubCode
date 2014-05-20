package com.balintimes.MMMS.Beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the framework_company database table.
 * 
 */
@Entity
@Table(name="framework_company")
@NamedQuery(name="FrameworkCompany.findAll", query="SELECT f FROM FrameworkCompany f")
public class FrameworkCompany implements Serializable {
	private static final long serialVersionUID = 1L;
	private String uid;
	private String name;
	private FrameworkCity frameworkCity;

	public FrameworkCompany() {
	}


	@Id
	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//bi-directional many-to-one association to FrameworkCity
	@ManyToOne
	@JoinColumn(name="CityUID")
	public FrameworkCity getFrameworkCity() {
		return this.frameworkCity;
	}

	public void setFrameworkCity(FrameworkCity frameworkCity) {
		this.frameworkCity = frameworkCity;
	}

}