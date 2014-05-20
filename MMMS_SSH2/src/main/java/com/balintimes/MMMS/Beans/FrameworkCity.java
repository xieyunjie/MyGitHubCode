package com.balintimes.MMMS.Beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the framework_city database table.
 * 
 */
@Entity
@Table(name="framework_city")
@NamedQuery(name="FrameworkCity.findAll", query="SELECT f FROM FrameworkCity f")
public class FrameworkCity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String uid;
	private String name;
	private Set<FrameworkCompany> frameworkCompanies;

	public FrameworkCity() {
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


	//bi-directional many-to-one association to FrameworkCompany
	@OneToMany(mappedBy="frameworkCity", fetch=FetchType.EAGER)
	public Set<FrameworkCompany> getFrameworkCompanies() {
		return this.frameworkCompanies;
	}

	public void setFrameworkCompanies(Set<FrameworkCompany> frameworkCompanies) {
		this.frameworkCompanies = frameworkCompanies;
	}

	public FrameworkCompany addFrameworkCompany(FrameworkCompany frameworkCompany) {
		getFrameworkCompanies().add(frameworkCompany);
		frameworkCompany.setFrameworkCity(this);

		return frameworkCompany;
	}

	public FrameworkCompany removeFrameworkCompany(FrameworkCompany frameworkCompany) {
		getFrameworkCompanies().remove(frameworkCompany);
		frameworkCompany.setFrameworkCity(null);

		return frameworkCompany;
	}

}