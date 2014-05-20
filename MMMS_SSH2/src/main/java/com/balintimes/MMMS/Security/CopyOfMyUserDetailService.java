package com.balintimes.MMMS.Security;

import java.util.*;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;

import com.balintimes.MMMS.Beans.MembershipUser;
import com.balintimes.MMMS.IService.IMembershipUserService;

public class CopyOfMyUserDetailService implements UserDetailsService
{

	@Resource
	private IMembershipUserService usersService;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException
	{
		MembershipUser users = null;
		MembershipUser user = null;
		users = (MembershipUser) this.usersService.getBy("username", username);
		if (users == null)
		{
			throw new UsernameNotFoundException(username);
		}
		Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(users);
		boolean enables = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		return new User(users.getUserName(), users.getPassword(), enables, accountNonExpired,
				credentialsNonExpired, accountNonLocked, grantedAuths); 
	}

	// 取得用户的权限资源
	private Set<GrantedAuthority> obtionGrantedAuthorities(MembershipUser user)
	{
		// Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		// Set<Roles> roles = user.getRoles();
		//
		// for (Roles role : roles)
		// {
		// authSet.add(new SimpleGrantedAuthority(role.getName()));
		// }
		// return authSet;

		return new HashSet<GrantedAuthority>(0);
	}

}
