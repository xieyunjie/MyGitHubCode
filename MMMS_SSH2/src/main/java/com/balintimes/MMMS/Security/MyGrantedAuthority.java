package com.balintimes.MMMS.Security;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.balintimes.MMMS.Beans.MembershipResource;
import com.balintimes.MMMS.Beans.MembershipResourceAuthority;
import com.balintimes.MMMS.Beans.MembershipRole; 

public class MyGrantedAuthority implements GrantedAuthority
{
	public MyGrantedAuthority()
	{
		// TODO Auto-generated constructor stub
	}
	
	
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
