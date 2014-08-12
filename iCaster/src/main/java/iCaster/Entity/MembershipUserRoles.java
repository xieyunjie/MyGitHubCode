package iCaster.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the membership_userroles database table.
 * 
 */
@Entity
@Table(name = "membership_userroles")
@NamedQuery(name = "MembershipUserRoles.findAll", query = "SELECT m FROM MembershipUserRoles m")
public class MembershipUserRoles implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private byte[] membershipRole;

	private String roleUID;

	private String userUID;

	public MembershipUserRoles()
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

	public byte[] getMembershipRole()
	{
		return this.membershipRole;
	}

	public void setMembershipRole(byte[] membershipRole)
	{
		this.membershipRole = membershipRole;
	}

	public String getRoleUID()
	{
		return this.roleUID;
	}

	public void setRoleUID(String roleUID)
	{
		this.roleUID = roleUID;
	}

	public String getUserUID()
	{
		return this.userUID;
	}

	public void setUserUID(String userUID)
	{
		this.userUID = userUID;
	}

}