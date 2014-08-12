package iCaster.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the membership_role database table.
 * 
 */
@Entity
@Table(name = "membership_role")
// @NamedQuery(name="MembershipRole.findAll",
// query="SELECT m FROM MembershipRole m")
@NamedQueries(
{
		@NamedQuery(name = "MembershipRole.findAll", query = "SELECT m FROM MembershipRole m"),
		@NamedQuery(name = "MembershipRole.getRolesByUserUID", query = "SELECT role FROM MembershipRole role, MembershipUserRoles ur \n" +
				"WHERE role.uid = ur.roleUID AND ur.userUID = ?1")
})
public class MembershipRole implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private byte enable;

	private String roleName;

	public MembershipRole()
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

	public byte getEnable()
	{
		return this.enable;
	}

	public void setEnable(byte enable)
	{
		this.enable = enable;
	}

	public String getRoleName()
	{
		return this.roleName;
	}

	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}

}