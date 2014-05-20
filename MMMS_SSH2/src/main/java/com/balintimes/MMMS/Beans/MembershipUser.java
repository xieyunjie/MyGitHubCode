package com.balintimes.MMMS.Beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the membership_user database table.
 * 
 */
@Entity
@Table(name="membership_user")
@NamedQuery(name="MembershipUser.findAll", query="SELECT m FROM MembershipUser m")
public class MembershipUser implements Serializable {
	private static final long serialVersionUID = 1L;
	private String uid;
	private byte enable;
	private String password;
	private String userName;
	private Set<MembershipUserRole> membershipUserroles;

	public MembershipUser() {
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


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	//bi-directional many-to-one association to MembershipUserRole
	@OneToMany(mappedBy="membershipUser", fetch=FetchType.EAGER)
	public Set<MembershipUserRole> getMembershipUserroles() {
		return this.membershipUserroles;
	}

	public void setMembershipUserroles(Set<MembershipUserRole> membershipUserroles) {
		this.membershipUserroles = membershipUserroles;
	}

	public MembershipUserRole addMembershipUserrole(MembershipUserRole membershipUserrole) {
		getMembershipUserroles().add(membershipUserrole);
		membershipUserrole.setMembershipUser(this);

		return membershipUserrole;
	}

	public MembershipUserRole removeMembershipUserrole(MembershipUserRole membershipUserrole) {
		getMembershipUserroles().remove(membershipUserrole);
		membershipUserrole.setMembershipUser(null);

		return membershipUserrole;
	}

}