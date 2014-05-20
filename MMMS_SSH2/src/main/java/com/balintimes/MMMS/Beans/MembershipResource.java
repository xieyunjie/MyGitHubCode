package com.balintimes.MMMS.Beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the membership_resource database table.
 * 
 */
@Entity
@Table(name="membership_resource")
@NamedQuery(name="MembershipResource.findAll", query="SELECT m FROM MembershipResource m")
public class MembershipResource implements Serializable {
	private static final long serialVersionUID = 1L;
	private String uid;
	private byte enable;
	private String resourceName;
	private int type;
	private String url;
	private Set<MembershipResourceAuthority> membershipResourceauthorities;

	public MembershipResource() {
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


	public String getResourceName() {
		return this.resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}


	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}


	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	//bi-directional many-to-one association to MembershipResourceAuthority
	@OneToMany(mappedBy="membershipResource", fetch=FetchType.EAGER)
	public Set<MembershipResourceAuthority> getMembershipResourceauthorities() {
		return this.membershipResourceauthorities;
	}

	public void setMembershipResourceauthorities(Set<MembershipResourceAuthority> membershipResourceauthorities) {
		this.membershipResourceauthorities = membershipResourceauthorities;
	}

	public MembershipResourceAuthority addMembershipResourceauthority(MembershipResourceAuthority membershipResourceauthority) {
		getMembershipResourceauthorities().add(membershipResourceauthority);
		membershipResourceauthority.setMembershipResource(this);

		return membershipResourceauthority;
	}

	public MembershipResourceAuthority removeMembershipResourceauthority(MembershipResourceAuthority membershipResourceauthority) {
		getMembershipResourceauthorities().remove(membershipResourceauthority);
		membershipResourceauthority.setMembershipResource(null);

		return membershipResourceauthority;
	}

}