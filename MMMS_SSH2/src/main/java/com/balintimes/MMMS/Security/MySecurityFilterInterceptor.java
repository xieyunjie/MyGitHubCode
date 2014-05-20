package com.balintimes.MMMS.Security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

public class MySecurityFilterInterceptor extends AbstractSecurityInterceptor implements Filter
{

	// 与applicationContext-security.xml里的myFilter的属性securityMetadataSource对应
	private FilterInvocationSecurityMetadataSource securityMetadataSource;

	@Override
	public Class<? extends Object> getSecureObjectClass()
	{
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource()
	{
		return this.securityMetadataSource;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{

		// System.out.println(request.getLocalName());

		FilterInvocation filterInvocation = new FilterInvocation(request, response, chain);
		invoke(filterInvocation);
	}

	private void invoke(FilterInvocation filterInvocation) throws IOException, ServletException
	{
		InterceptorStatusToken token = null;
		token = super.beforeInvocation(filterInvocation);

		try
		{
			filterInvocation.getChain().doFilter(filterInvocation.getRequest(), filterInvocation.getResponse());
		}
		finally
		{
			super.afterInvocation(token, null);
		}
	}

	public FilterInvocationSecurityMetadataSource getSecurityMetadataSource()
	{
		return securityMetadataSource;
	}

	public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource securityMetadataSource)
	{
		this.securityMetadataSource = securityMetadataSource;
	}

	public void init(FilterConfig filterConfig) throws ServletException
	{

	}

	public void destroy()
	{

	}
}
