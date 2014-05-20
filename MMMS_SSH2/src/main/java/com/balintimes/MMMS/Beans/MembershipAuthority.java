package com.balintimes.MMMS.Beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the membership_authority database table.
 * 
 */
@Entity
@Table(name="membership_authority")
@NamedQuery(name="MembershipAuthority.findAll", query="SELECT m FROM MembershipAuthority m")
public class MembershipAuthority implements Serializable {
	private static final long serialVersionUID = 1L;
	private String uid;
	private String authName;
	private byte enable;
	private Set<MembershipResourceAuthority> membershipResourceauthorities;

	public MembershipAuthority() {
	}


	@Id
	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}


	public String getAuthName() {
		return this.authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}


	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}


	//bi-directional many-to-one association to MembershipResourceAuthority
	@OneToMany(mappedBy="membershipAuthority", fetch=FetchType.EAGER)
	public Set<MembershipResourceAuthority> getMembershipResourceauthorities() {
		return this.membershipResourceauthorities;
	}

	public void setMembershipResourceauthorities(Set<MembershipResourceAuthority> membershipResourceauthorities) {
		this.membershipResourceauthorities = membershipResourceauthorities;
	}

	public MembershipResourceAuthority addMembershipResourceauthority(MembershipResourceAuthority membershipResourceauthority) {
		getMembershipResourceauthorities().add(membershipResourceauthority);
		membershipResourceauthority.setMembershipAuthority(this);

		return membershipResourceauthority;
	}

	public MembershipResourceAuthority removeMembershipResourceauthority(MembershipResourceAuthority membershipResourceauthority) {
		getMembershipResourceauthorities().remove(membershipResourceauthority);
		membershipResourceauthority.setMembershipAuthority(null);

		return membershipResourceauthority;
	}

}