package com.balintimes.MMMS.IService;

import java.io.Serializable;
import java.util.Set;
 

import com.balintimes.MMMS.Beans.MembershipResource;
import com.balintimes.MMMS.Beans.MembershipRole;
import com.balintimes.MMMS.Beans.MembershipRoleAuthority;
import com.balintimes.MMMS.Beans.MembershipUser;

public interface IMembershipUserService<T extends Serializable> extends IBaseService<T>
{ 	/*
	 * 获取用户权限
	 * userName 用户名
	 * userResources 用户资源
	 * userAuthorities 用户的资源权限
	 * userRoles 用户角色
	 * */
	MembershipUser GetUserResourceAndAuthority(String userName, Set<MembershipResource> userResources, Set<MembershipRoleAuthority> userAuthorities, Set<MembershipRole> userRoles);
}
