package iCaster.Security;

import iCaster.Entity.MembershipResource;
import iCaster.Entity.MembershipResourceAuthority;
import iCaster.Model.UserResourceAuthorityType;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;

public class WebAccessDecisionManager implements AccessDecisionManager
{ 
	/*
	 * configAttributes 来自于 MySecurityMetadataSource 可暂存权限信息列表
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
		// 所请求的资源拥有的权限(一个资源对多个权限)
		Iterator<ConfigAttribute> iterator = configAttributes.iterator();
 
		while (iterator.hasNext())
		{
			WebConfigAttribute myConfigAttribute = (WebConfigAttribute) iterator.next();

			if (myConfigAttribute.getUserResourceAuthorityType() == UserResourceAuthorityType.Forbidden)
			{
				throw new AccessDeniedException(" 没有权限访问！ ");
			}
			else if (myConfigAttribute.getUserResourceAuthorityType() == UserResourceAuthorityType.PassAnyway)
			{
				return;
			}
			else if (myConfigAttribute.getUserResourceAuthorityType() == UserResourceAuthorityType.Resource)
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
				for (MembershipResourceAuthority authority : userDetails.getUserAuthorities())
				{ 
					if (authority.getUid().compareToIgnoreCase(myConfigAttribute.getUid()) == 0)
					{
						return;
					}
				}
			}
		}

		// // 所请求的资源拥有的权限(一个资源对多个权限)
		// Iterator<ConfigAttribute> iterator = configAttributes.iterator();
		//
		// while (iterator.hasNext())
		// {
		// ConfigAttribute configAttribute = iterator.next();
		//
		// // 访问所请求资源所需要的权限
		// String needPermission = ((SecurityConfig)
		// configAttribute).getAttribute();
		//
		// System.out.println("need Permission is " + needPermission);
		//
		// // 用户所拥有的权限authentication
		// for (GrantedAuthority ga : authentication.getAuthorities())
		// {
		// // System.out.println(ga.getAuthority());
		// if (needPermission.equals(ga.getAuthority()))
		// {
		// return;
		// }
		// }
		// }
		// 没有权限
		throw new AccessDeniedException(" 没有权限访问！ ");
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
	// throw new AccessDeniedException("没有权限访问!");
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
