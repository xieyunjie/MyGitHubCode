package com.balintimes.MMMS.Beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the membership_role database table.
 * 
 */
@Entity
@Table(name="membership_role")
@NamedQuery(name="MembershipRole.findAll", query="SELECT m FROM MembershipRole m")
public class MembershipRole implements Serializable {
	private static final long serialVersionUID = 1L;
	private String uid;
	private byte enable;
	private String roleName;
	private Set<MembershipRoleAuthority> membershipRoleauthorities;
	private Set<MembershipUserRole> membershipUserroles;

	public MembershipRole() {
	}


	@Id
	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}


	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}


	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	//bi-directional many-to-one association to MembershipRoleAuthority
	@OneToMany(mappedBy="membershipRole", fetch=FetchType.EAGER)
	public Set<MembershipRoleAuthority> getMembershipRoleauthorities() {
		return this.membershipRoleauthorities;
	}

	public void setMembershipRoleauthorities(Set<MembershipRoleAuthority> membershipRoleauthorities) {
		this.membershipRoleauthorities = membershipRoleauthorities;
	}

	public MembershipRoleAuthority addMembershipRoleauthority(MembershipRoleAuthority membershipRoleauthority) {
		getMembershipRoleauthorities().add(membershipRoleauthority);
		membershipRoleauthority.setMembershipRole(this);

		return membershipRoleauthority;
	}

	public MembershipRoleAuthority removeMembershipRoleauthority(MembershipRoleAuthority membershipRoleauthority) {
		getMembershipRoleauthorities().remove(membershipRoleauthority);
		membershipRoleauthority.setMembershipRole(null);

		return membershipRoleauthority;
	}


	//bi-directional many-to-one association to MembershipUserRole
	@OneToMany(mappedBy="membershipRoleBean", fetch=FetchType.EAGER)
	public Set<MembershipUserRole> getMembershipUserroles() {
		return this.membershipUserroles;
	}

	public void setMembershipUserroles(Set<MembershipUserRole> membershipUserroles) {
		this.membershipUserroles = membershipUserroles;
	}

	public MembershipUserRole addMembershipUserrole(MembershipUserRole membershipUserrole) {
		getMembershipUserroles().add(membershipUserrole);
		membershipUserrole.setMembershipRoleBean(this);

		return membershipUserrole;
	}

	public MembershipUserRole removeMembershipUserrole(MembershipUserRole membershipUserrole) {
		getMembershipUserroles().remove(membershipUserrole);
		membershipUserrole.setMembershipRoleBean(null);

		return membershipUserrole;
	}

}