package iCaster.Security;

import iCaster.Entity.MembershipRole;
import iCaster.Entity.MembershipUser;
import iCaster.Model.UserLoginInfo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class WebUserDetailService implements UserDetailsService
{

	// @Autowired

	private SpringMembershipUserService userService;

	public SpringMembershipUserService getUserService()
	{
		return userService;
	}

	public void setUserService(SpringMembershipUserService userService)
	{
		this.userService = userService;
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException
	{

		UserLoginInfo userLoginInfo = this.userService.GetUserResourceAndAuthority(username);

		if (userLoginInfo == null)
		{
			throw new UsernameNotFoundException("当前用户或密码录入错误");
		}
		MembershipUser user = userLoginInfo.getUser(); 

		// 暂使用 用户角色 测试
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>(userLoginInfo.getUserRoles().size());
		for (MembershipRole role : userLoginInfo.getUserRoles())
		{
			// grantedAuthorities.add(new
			// SimpleGrantedAuthority(role.getRoleName()));
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}

		Boolean enabled = true, accountNonExpired = true, credentialsNonExpired = true, accountNonLocked = true;

		String employeeName = "employeeName", employeeUID = "employeeUID";

		WebUserDetails webUserDetails = new WebUserDetails(user.getUserName(), user.getPassword(), enabled,
				accountNonExpired, credentialsNonExpired, accountNonLocked,
				grantedAuthorities,
				userLoginInfo.getUserResources(), userLoginInfo.getUserAuthorities(), userLoginInfo.getUserRoles(), user.getUid(), employeeName, employeeUID);

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
