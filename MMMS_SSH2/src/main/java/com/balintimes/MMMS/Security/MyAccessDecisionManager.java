package com.balintimes.MMMS.Security;

import java.util.Iterator;
import java.util.Collection;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.web.bind.WebDataBinder;

import com.balintimes.MMMS.Beans.MembershipResource;
import com.balintimes.MMMS.Beans.MembershipRoleAuthority;
import com.balintimes.MMMS.Model.UserResourceAuthorityType;

public class MyAccessDecisionManager implements AccessDecisionManager
{
	/*
	 * configAttributes ������ MySecurityMetadataSource ���ݴ�Ȩ����Ϣ�б�
	 */
	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException
	{

		if (configAttributes == null)
		{
			return;
		}

		WebUserDetails userDetails = (WebUserDetails) authentication.getPrincipal();
		System.out.println("this object value is: " + object.toString());
		// ���������Դӵ�е�Ȩ��(һ����Դ�Զ��Ȩ��)
		Iterator<ConfigAttribute> iterator = configAttributes.iterator();

		while (iterator.hasNext())
		{
			MyConfigAttribute myConfigAttribute = (MyConfigAttribute) iterator.next();

			if (myConfigAttribute.getUserResourceAuthorityType() == UserResourceAuthorityType.Forbidden)
			{
				throw new AccessDeniedException(" û��Ȩ�޷��ʣ� ");
			}

			if (myConfigAttribute.getUserResourceAuthorityType() == UserResourceAuthorityType.Resource)
			{
				for (MembershipResource resource : userDetails.getUserResources())
				{
					if (resource.getUid().compareToIgnoreCase(myConfigAttribute.getUid()) == 0)
					{
						return;
					}
				}
			}
			else
			{
				for (MembershipRoleAuthority authority : userDetails.getUserAuthorities())
				{
					if (authority.getMembershipResourceauthority().getUid().compareToIgnoreCase(myConfigAttribute.getUid()) == 0)
					{
						return;
					}
				}
			}
		}

		// // ���������Դӵ�е�Ȩ��(һ����Դ�Զ��Ȩ��)
		// Iterator<ConfigAttribute> iterator = configAttributes.iterator();
		//
		// while (iterator.hasNext())
		// {
		// ConfigAttribute configAttribute = iterator.next();
		//
		// // ������������Դ����Ҫ��Ȩ��
		// String needPermission = ((SecurityConfig)
		// configAttribute).getAttribute();
		//
		// System.out.println("need Permission is " + needPermission);
		//
		// // �û���ӵ�е�Ȩ��authentication
		// for (GrantedAuthority ga : authentication.getAuthorities())
		// {
		// // System.out.println(ga.getAuthority());
		// if (needPermission.equals(ga.getAuthority()))
		// {
		// return;
		// }
		// }
		// }
		// û��Ȩ��
		throw new AccessDeniedException(" û��Ȩ�޷��ʣ� ");
	}

	// @Override
	// public void decide(Authentication authentication, Object object,
	// Collection<ConfigAttribute> configAttributes)
	// throws AccessDeniedException, InsufficientAuthenticationException
	// {
	//
	// boolean test = true;
	// if (test == true)
	// {
	// return;
	// }
	//
	//
	// System.out.println("############  decide  ####################");
	// throw new AccessDeniedException("û��Ȩ�޷���!");
	// }

	@Override
	public boolean supports(ConfigAttribute attribute)
	{

		return true;
	}

	@Override
	public boolean supports(Class<?> clazz)
	{

		return true;
	}

}