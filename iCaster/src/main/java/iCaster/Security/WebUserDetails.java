package iCaster.Security;

import iCaster.Entity.MembershipResource;
import iCaster.Entity.MembershipResourceAuthority;
import iCaster.Entity.MembershipRole;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class WebUserDetails extends User implements UserDetails
{

	public WebUserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities)
	{
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
	}

	public WebUserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities,
			List<MembershipResource> userResources, List<MembershipResourceAuthority> userAuthorities, List<MembershipRole> userRoles,
			String userUID, String employeeName, String employeeUID)
	{
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
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

	// private String username;
	// private String password;
	// private boolean userEnabled;
	// private Collection<GrantedAuthority> authorities;
	// private boolean accountNonExpired;
	// private boolean accountNonLocked;
	// private boolean credentialsNonExpired;
	/*
	 * 自定义字段
	 */
	private List<MembershipResource> userResources;
	private List<MembershipResourceAuthority> userAuthorities;
	private List<MembershipRole> userRoles;
	private String userUID;
	private String employeeName;
	private String employeeUID;

	//
	// @Override
	// public String getUsername()
	// {
	// return username;
	// }
	//
	// @Override
	// public String getPassword()
	// {
	// return password;
	// }
	//
	// @Override
	// public Collection<GrantedAuthority> getAuthorities()
	// {
	// return authorities;
	// }
	//
	// @Override
	// public boolean isAccountNonExpired()
	// {
	// return accountNonExpired;
	// }
	//
	// @Override
	// public boolean isAccountNonLocked()
	// {
	// return accountNonLocked;
	// }
	//
	// @Override
	// public boolean isCredentialsNonExpired()
	// {
	// return credentialsNonExpired;
	// }
	//
	// @Override
	// public boolean isEnabled()
	// {
	//
	// return userEnabled;
	// }

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
