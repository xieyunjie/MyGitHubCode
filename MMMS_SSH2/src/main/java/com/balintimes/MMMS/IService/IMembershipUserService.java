package com.balintimes.MMMS.IService;

import java.io.Serializable;
import java.util.Set;
 

import com.balintimes.MMMS.Beans.MembershipResource;
import com.balintimes.MMMS.Beans.MembershipRole;
import com.balintimes.MMMS.Beans.MembershipRoleAuthority;
import com.balintimes.MMMS.Beans.MembershipUser;

public interface IMembershipUserService<T extends Serializable> extends IBaseService<T>
{ 	/*
	 * ��ȡ�û�Ȩ��
	 * userName �û���
	 * userResources �û���Դ
	 * userAuthorities �û�����ԴȨ��
	 * userRoles �û���ɫ
	 * */
	MembershipUser GetUserResourceAndAuthority(String userName, Set<MembershipResource> userResources, Set<MembershipRoleAuthority> userAuthorities, Set<MembershipRole> userRoles);
}
