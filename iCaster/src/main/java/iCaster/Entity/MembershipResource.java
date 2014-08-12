package iCaster.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the membership_resource database table.
 * 
 */
@Entity
@Table(name = "membership_resource")
// @NamedQuery(name="MembershipResource.findAll",
// query="SELECT m FROM MembershipResource m")
@NamedQueries(
{
		@NamedQuery(name = "MembershipResource.findAll", query = "SELECT m FROM MembershipResource m"),
		@NamedQuery(name = "MembershipRole.getResourceByUserUID", query = "SELECT re FROM MembershipResource re\n" +
				"WHERE EXISTS( SELECT 1 FROM MembershipRole role, MembershipUserRoles ur ,MembershipRoleAuthority ra ,MembershipResourceAuthority rea\n" +
				"WHERE role.uid = ur.roleUID  AND role.uid = ra.roleUID AND ra.resourceAuthorityUID = rea.uid AND re.uid = rea.resourceUID AND ur.userUID = ?1)")
})
public class MembershipResource implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private byte enable;

	private String resourceName;

	private int type;

	private String url;

	public MembershipResource()
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

	public String getResourceName()
	{
		return this.resourceName;
	}

	public void setResourceName(String resourceName)
	{
		this.resourceName = resourceName;
	}

	public int getType()
	{
		return this.type;
	}

	public void setType(int type)
	{
		this.type = type;
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