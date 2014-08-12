package iCaster.Model;
 
import iCaster.Entity.MembershipResource;
import iCaster.Entity.MembershipResourceAuthority;
import iCaster.Entity.MembershipRole;
import iCaster.Entity.MembershipUser;

import java.util.List;

public class UserLoginInfo
{
	private List<MembershipResource> userResources;
	private List<MembershipResourceAuthority> userAuthorities;
	private List<MembershipRole> userRoles;
	private MembershipUser user;

	public UserLoginInfo()
	{
		// TODO Auto-generated constructor stub
	}

	public List<MembershipResource> getUserResources()
	{
		return userResources;
	}

	public void setUserResources(List<MembershipResource> userResources)
	{
		this.userResources = userResources;
	}

	public List<MembershipResourceAuthority> getUserAuthorities()
	{
		return userAuthorities;
	}

	public void setUserAuthorities(List<MembershipResourceAuthority> userAuthorities)
	{
		this.userAuthorities = userAuthorities;
	}

	public List<MembershipRole> getUserRoles()
	{
		return userRoles;
	}

	public void setUserRoles(List<MembershipRole> userRoles)
	{
		this.userRoles = userRoles;
	}

	public MembershipUser getUser()
	{
		return user;
	}

	public void setUser(MembershipUser user)
	{
		this.user = user;
	}

}
