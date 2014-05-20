package com.balintimes.MMMS.Beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the membership_resourceauthorities database table.
 * 
 */
@Entity
@Table(name="membership_resourceauthorities")
@NamedQuery(name="MembershipResourceAuthority.findAll", query="SELECT m FROM MembershipResourceAuthority m")
public class MembershipResourceAuthority implements Serializable {
	private static final long serialVersionUID = 1L;
	private String uid;
	private String url;
	private MembershipAuthority membershipAuthority;
	private MembershipResource membershipResource;
	private Set<MembershipRoleAuthority> membershipRoleauthorities;

	public MembershipResourceAuthority() {
	}


	@Id
	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}


	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	//bi-directional many-to-one association to MembershipAuthority
	@ManyToOne
	@JoinColumn(name="AuthorityUID")
	public MembershipAuthority getMembershipAuthority() {
		return this.membershipAuthority;
	}

	public void setMembershipAuthority(MembershipAuthority membershipAuthority) {
		this.membershipAuthority = membershipAuthority;
	}


	//bi-directional many-to-one association to MembershipResource
	@ManyToOne
	@JoinColumn(name="ResourceUID")
	public MembershipResource getMembershipResource() {
		return this.membershipResource;
	}

	public void setMembershipResource(MembershipResource membershipResource) {
		this.membershipResource = membershipResource;
	}


	//bi-directional many-to-one association to MembershipRoleAuthority
	@OneToMany(mappedBy="membershipResourceauthority", fetch=FetchType.EAGER)
	public Set<MembershipRoleAuthority> getMembershipRoleauthorities() {
		return this.membershipRoleauthorities;
	}

	public void setMembershipRoleauthorities(Set<MembershipRoleAuthority> membershipRoleauthorities) {
		this.membershipRoleauthorities = membershipRoleauthorities;
	}

	public MembershipRoleAuthority addMembershipRoleauthority(MembershipRoleAuthority membershipRoleauthority) {
		getMembershipRoleauthorities().add(membershipRoleauthority);
		membershipRoleauthority.setMembershipResourceauthority(this);

		return membershipRoleauthority;
	}

	public MembershipRoleAuthority removeMembershipRoleauthority(MembershipRoleAuthority membershipRoleauthority) {
		getMembershipRoleauthorities().remove(membershipRoleauthority);
		membershipRoleauthority.setMembershipResourceauthority(null);

		return membershipRoleauthority;
	}

}