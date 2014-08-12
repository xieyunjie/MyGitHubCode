package iCaster.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the membership_roleauthorities database table.
 * 
 */
@Entity
@Table(name = "membership_roleauthorities")
// @NamedQuery(name="MembershipRoleAuthority.findAll",
// query="SELECT m FROM MembershipRoleAuthority m")
@NamedQueries(
{
		@NamedQuery(name = "MembershipRoleAuthority.findAll", query = "SELECT m FROM MembershipRoleAuthority m"),
		@NamedQuery(name = "MembershipRoleAuthority.getRoleAuthorityByUserUID", query = "SELECT ra FROM MembershipRole role, MembershipUserRoles ur ,MembershipRoleAuthority ra\n" +
				"WHERE role.uid = ur.roleUID  AND role.uid = ra.roleUID AND ur.userUID = ?1")
})
public class MembershipRoleAuthority implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String resourceAuthorityUID;

	private String roleUID;

	public MembershipRoleAuthority()
	{
	}

	public int getId()
	{
		return this.id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getResourceAuthorityUID()
	{
		return this.resourceAuthorityUID;
	}

	public void setResourceAuthorityUID(String resourceAuthorityUID)
	{
		this.resourceAuthorityUID = resourceAuthorityUID;
	}

	public String getRoleUID()
	{
		return this.roleUID;
	}

	public void setRoleUID(String roleUID)
	{
		this.roleUID = roleUID;
	}

}