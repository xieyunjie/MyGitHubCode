package com.balintimes.MMMS.Security;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.annotation.Resource.AuthenticationType;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.balintimes.MMMS.Beans.MembershipResource;
import com.balintimes.MMMS.Beans.MembershipResourceAuthority;
import com.balintimes.MMMS.IService.IMembershipResourceService;
import com.balintimes.MMMS.Model.UserResourceAuthority;
import com.balintimes.MMMS.Model.UserResourceAuthorityType;

public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource
{
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
	
	private static MyConfigAttribute forbiddenConfigAttribute = new MyConfigAttribute("", "", UserResourceAuthorityType.Forbidden);

	@Resource
	private IMembershipResourceService resourcesService;

	// @PostConstruct
	public void initResource()
	{
		if (resourceMap == null)
		{
			List<MembershipResource> resources = this.resourcesService.query("");

			if (resources == null)
			{
				return;
			}
			resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
			for (MembershipResource membershipResource : resources)
			{
				Set<ConfigAttribute> attributesSet = new HashSet<ConfigAttribute>();

				for (MembershipResourceAuthority Authority : membershipResource.getMembershipResourceauthorities())
				{
					attributesSet.add(new SecurityConfig(Authority.getUid()));
				}

				resourceMap.put(membershipResource.getUrl(), attributesSet);
			}
		}
	}

	// 由spring调用
	// 一定要使用这种方法注入才可以使用？
	// public MySecurityMetadataSource(IResourcesService iresourceSvc)
	// {
	// this.resourcesService = iresourceSvc;
	// loadResourceDefine();
	// }

	public MySecurityMetadataSource()
	{
	}

	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException
	{
		HttpServletRequest request = ((FilterInvocation) object).getRequest();
		// // 获得请求的URL地址
		String requestUrl = ((FilterInvocation) object).getRequest().getServletPath(); 

		RequestMatcher requestMatcher = new AntPathRequestMatcher(requestUrl);
		if (requestMatcher.matches(request))
		{ 
			UserResourceAuthority authority = this.resourcesService.GetUserResourceAndAuthorityByURL(requestUrl);
			Set<ConfigAttribute> attributesSet = new HashSet<ConfigAttribute>(1);
			if (authority == null)
			{
				attributesSet.add(forbiddenConfigAttribute);
			} 
			else {
				attributesSet.add(new MyConfigAttribute(authority.getUid(), authority.getUrl(), authority.getUserResourceAuthorityType()));
			}
			return attributesSet;
		}
		
		return null;

		// Set<ConfigAttribute> attributesSet = new HashSet<ConfigAttribute>(3);
		//
		// attributesSet.add(new SecurityConfig("config1"));
		// attributesSet.add(new SecurityConfig("config2"));
		// attributesSet.add(new SecurityConfig("config3"));
		//
		//
		// return attributesSet;

		// if (resourceMap == null)
		// {
		// initResource();
		// }
		//
		// if (resourceMap.get(requestUrl) == null)
		// {
		// return null;
		// }
		// System.out.println(resourceMap.get(requestUrl));

		// 动态资源管理
		// if (resourceMap.get(requestUrl) == null)
		// {
		// Collection<ConfigAttribute> configAttributes = new
		// ArrayList<ConfigAttribute>();
		// Resources resource = (Resources) this.resourcesService.getBy("url",
		// requestUrl);
		// if (resource == null)
		// {
		// return null;
		// }
		// Set<Roles> roles = resource.getRoles();
		// for (Roles role : roles)
		// {
		// ConfigAttribute configAttribute = new SecurityConfig(role.getName());
		// configAttributes.add(configAttribute);
		// resourceMap.put(resource.getUrl(), configAttributes);
		// }
		// }

		// return resourceMap.get(requestUrl);

	}

	public Collection<ConfigAttribute> getAllConfigAttributes()
	{

		return null;
	}

	public boolean supports(Class<?> clazz)
	{

		return true;
	}

}
