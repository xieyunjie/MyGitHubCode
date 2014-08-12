package iCaster.IService;

import iCaster.Entity.MembershipUser;
import iCaster.Model.UserLoginInfo;

public interface IMembershipUserService extends IBaseService<MembershipUser>
{
	/*
	 * 获取用户权限
	 * userName 用户名
	 * userResources 用户资源
	 * userAuthorities 用户的资源权限
	 * userRoles 用户角色
	 */
	UserLoginInfo GetUserResourceAndAuthority(String userName);
}
