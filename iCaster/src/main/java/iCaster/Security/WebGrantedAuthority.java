package iCaster.Security;

import iCaster.Entity.MembershipResource;
import iCaster.Entity.MembershipResourceAuthority;
import iCaster.Entity.MembershipRole;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class WebGrantedAuthority implements GrantedAuthority
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<MembershipResource> userResources;
	private List<MembershipResourceAuthority> userAuthorities;
	private List<MembershipRole> userRoles;

	@Override
	public String getAuthority()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public List<MembershipResource> getUserResources()
	{
		return userResources;
	}

	public List<MembershipResourceAuthority> getUserAuthorities()
	{
		return userAuthorities;
	}

	public List<MembershipRole> getUserRoles()
	{
		return userRoles;
	}
}
