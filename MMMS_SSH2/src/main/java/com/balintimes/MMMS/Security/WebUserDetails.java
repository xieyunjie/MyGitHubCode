package com.balintimes.MMMS.Security;

import java.util.Collection;
import java.util.Set; 

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.balintimes.MMMS.Beans.MembershipResource;
import com.balintimes.MMMS.Beans.MembershipRole;
import com.balintimes.MMMS.Beans.MembershipRoleAuthority;

//public class WebUserDetails  extends User
//{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 4418403124374996698L;
//
//	public WebUserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities)
//	{
//		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
//		// TODO Auto-generated constructor stub
//	}
//	
//}

public class WebUserDetails extends User implements UserDetails
{
	public WebUserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities)
	{
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
	}

	public WebUserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities,
			Set<MembershipResource> userResources, Set<MembershipRoleAuthority> userAuthorities, Set<MembershipRole> userRoles,
			String userUID, String employeeName, String employeeUID)
	{
		super(username,password,enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,authorities);
		// this.username = username;
		// this.password = username;
		// this.userEnabled = enabled;
		// this.accountNonExpired = accountNonExpired;
		// this.credentialsNonExpired = credentialsNonExpired;
		// this.accountNonLocked = accountNonLocked;
		// this.authorities = (Collection<GrantedAuthority>) authorities;

		this.userResources = userResources;
		this.userAuthorities = userAuthorities;
		this.userRoles = userRoles;
		this.userUID = userUID;
		this.employeeName = employeeName;
		this.employeeUID = employeeUID;

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8514936528514645778L;

//	private String username;
//	private String password;
//	private boolean userEnabled;
//	private Collection<GrantedAuthority> authorities;
//	private boolean accountNonExpired;
//	private boolean accountNonLocked;
//	private boolean credentialsNonExpired;
	/*
	 * ×Ô¶¨Òå×Ö¶Î
	 */
	private Set<MembershipResource> userResources;
	private Set<MembershipRoleAuthority> userAuthorities;
	private Set<MembershipRole> userRoles;
	private String userUID;
	private String employeeName;
	private String employeeUID;
//
//	@Override
//	public String getUsername()
//	{
//		return username;
//	}
//
//	@Override
//	public String getPassword()
//	{
//		return password;
//	}
//
//	@Override
//	public Collection<GrantedAuthority> getAuthorities()
//	{
//		return authorities;
//	}
//
//	@Override
//	public boolean isAccountNonExpired()
//	{
//		return accountNonExpired;
//	}
//
//	@Override
//	public boolean isAccountNonLocked()
//	{
//		return accountNonLocked;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired()
//	{
//		return credentialsNonExpired;
//	}
//
//	@Override
//	public boolean isEnabled()
//	{
//
//		return userEnabled;
//	}

	public Set<MembershipResource> getUserResources()
	{
		return userResources;
	}

	public Set<MembershipRoleAuthority> getUserAuthorities()
	{
		return userAuthorities;
	}

	public Set<MembershipRole> getUserRoles()
	{
		return userRoles;
	}

	public String getUserUID()
	{
		return userUID;
	}

	public String getEmployeeName()
	{
		return employeeName;
	}

	public String getEmployeeUID()
	{
		return employeeUID;
	}

}
