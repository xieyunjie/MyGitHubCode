package iCaster.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the membership_resourceauthorities database table.
 * 
 */
@Entity
@Table(name = "membership_resourceauthorities")
// @NamedQuery(name="MembershipResourceAuthority.findAll",
// query="SELECT m FROM MembershipResourceAuthority m")
@NamedQueries(
{
		@NamedQuery(name = "MembershipResourceAuthority.findAll", query = "SELECT m FROM MembershipResourceAuthority m"),
		@NamedQuery(name = "MembershipResourceAuthority.getResourceAuthByUserUID", query = "SELECT rea FROM MembershipResourceAuthority rea\n" +
				"WHERE EXISTS( SELECT 1 FROM MembershipRole role, MembershipUserRoles ur ,MembershipRoleAuthority ra ,MembershipResourceAuthority rea\n" +
				"WHERE role.uid = ur.roleUID  AND role.uid = ra.roleUID AND ra.resourceAuthorityUID = rea.uid  AND ur.userUID = ?1)")
})
public class MembershipResourceAuthority implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String authorityUID;

	private String resourceUID;

	private String url;

	public MembershipResourceAuthority()
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

	public String getAuthorityUID()
	{
		return this.authorityUID;
	}

	public void setAuthorityUID(String authorityUID)
	{
		this.authorityUID = authorityUID;
	}

	public String getResourceUID()
	{
		return this.resourceUID;
	}

	public void setResourceUID(String resourceUID)
	{
		this.resourceUID = resourceUID;
	}

	public String getUrl()
	{
		return this.url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

}