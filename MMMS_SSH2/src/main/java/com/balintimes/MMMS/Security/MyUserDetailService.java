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

import com.balintimes.MMMS.Beans.FrameworkCity;
import com.balintimes.MMMS.Beans.FrameworkCompany;
import com.balintimes.MMMS.Beans.MembershipResource;
import com.balintimes.MMMS.Beans.MembershipRole;
import com.balintimes.MMMS.Beans.MembershipRoleAuthority;
import com.balintimes.MMMS.Beans.MembershipUser;
import com.balintimes.MMMS.IService.IFrameworkCityService;
import com.balintimes.MMMS.IService.IMembershipUserService;

public class MyUserDetailService implements UserDetailsService
{

	@Resource
	private IMembershipUserService userService;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException
	{
		Set<MembershipResource> userResources = new HashSet<MembershipResource>(0);
		Set<MembershipRoleAuthority> userAuthorities = new HashSet<MembershipRoleAuthority>(0);
		Set<MembershipRole> userRoles = new HashSet<MembershipRole>(0);

		@SuppressWarnings("unchecked")
		MembershipUser user = this.userService.GetUserResourceAndAuthority(username, userResources, userAuthorities, userRoles);

		if (user == null)
		{
			throw new UsernameNotFoundException("当前用户或密码录入错误");
		}

		// 暂使用 用户角色 测试
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>(userRoles.size());
		for (MembershipRole role : userRoles)
		{
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}

		Boolean enabled = true, accountNonExpired = true, credentialsNonExpired = true, accountNonLocked = true;

		String employeeName = "employeeName", employeeUID = "employeeUID";

		WebUserDetails webUserDetails = new WebUserDetails(user.getUserName(), user.getPassword(), enabled,
				accountNonExpired, credentialsNonExpired, accountNonLocked,
				grantedAuthorities,
				userResources,userAuthorities,userRoles,user.getUid(),employeeName,employeeUID);

		// WebUserDetails webUserDetails = new
		// WebUserDetails(user.getUserName(), user.getPassword(),
		// enabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
		// grantedAuthorities, userResources, userAuthorities, userRoles,
		// user.getUid(), employeeName, employeeUID);
		return webUserDetails;

		// MembershipUser users = null;
		// MembershipUser user = null;
		// users = (MembershipUser) this.usersService.getBy("username",
		// username);
		// if (users == null)
		// {
		// throw new UsernameNotFoundException(username);
		// }
		// Collection<GrantedAuthority> grantedAuths =
		// obtionGrantedAuthorities(users);
		// boolean enables = true;
		// boolean accountNonExpired = true;
		// boolean credentialsNonExpired = true;
		// boolean accountNonLocked = true;
		//
		// return new User(users.getUserName(), users.getPassword(), enables,
		// accountNonExpired,
		// credentialsNonExpired, accountNonLocked, grantedAuths);

	}
	// // 取得用户的权限资源
	// private Set<GrantedAuthority> obtionGrantedAuthorities(MembershipUser
	// user)
	// {
	// // Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
	// // Set<Roles> roles = user.getRoles();
	// //
	// // for (Roles role : roles)
	// // {
	// // authSet.add(new SimpleGrantedAuthority(role.getName()));
	// // }
	// // return authSet;
	//
	// return new HashSet<GrantedAuthority>(0);
	// }

}
