package com.balintimes.MMMS.Beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the membership_userroles database table.
 * 
 */
@Entity
@Table(name="membership_userroles")
@NamedQuery(name="MembershipUserRole.findAll", query="SELECT m FROM MembershipUserRole m")
public class MembershipUserRole implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private byte[] membershipRole;
	private MembershipRole membershipRoleBean;
	private MembershipUser membershipUser;

	public MembershipUserRole() {
	}


	@Id
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Lob
	public byte[] getMembershipRole() {
		return this.membershipRole;
	}

	public void setMembershipRole(byte[] membershipRole) {
		this.membershipRole = membershipRole;
	}


	//bi-directional many-to-one association to MembershipRole
	@ManyToOne
	@JoinColumn(name="RoleUID")
	public MembershipRole getMembershipRoleBean() {
		return this.membershipRoleBean;
	}

	public void setMembershipRoleBean(MembershipRole membershipRoleBean) {
		this.membershipRoleBean = membershipRoleBean;
	}


	//bi-directional many-to-one association to MembershipUser
	@ManyToOne
	@JoinColumn(name="UserUID")
	public MembershipUser getMembershipUser() {
		return this.membershipUser;
	}

	public void setMembershipUser(MembershipUser membershipUser) {
		this.membershipUser = membershipUser;
	}

}