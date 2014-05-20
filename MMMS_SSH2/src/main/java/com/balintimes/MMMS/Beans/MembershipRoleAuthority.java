package com.balintimes.MMMS.Beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the membership_roleauthorities database table.
 * 
 */
@Entity
@Table(name="membership_roleauthorities")
@NamedQuery(name="MembershipRoleAuthority.findAll", query="SELECT m FROM MembershipRoleAuthority m")
public class MembershipRoleAuthority implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private MembershipResourceAuthority membershipResourceauthority;
	private MembershipRole membershipRole;

	public MembershipRoleAuthority() {
	}


	@Id
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	//bi-directional many-to-one association to MembershipResourceAuthority
	@ManyToOne
	@JoinColumn(name="ResourceAuthorityUID")
	public MembershipResourceAuthority getMembershipResourceauthority() {
		return this.membershipResourceauthority;
	}

	public void setMembershipResourceauthority(MembershipResourceAuthority membershipResourceauthority) {
		this.membershipResourceauthority = membershipResourceauthority;
	}


	//bi-directional many-to-one association to MembershipRole
	@ManyToOne
	@JoinColumn(name="RoleUID")
	public MembershipRole getMembershipRole() {
		return this.membershipRole;
	}

	public void setMembershipRole(MembershipRole membershipRole) {
		this.membershipRole = membershipRole;
	}

}