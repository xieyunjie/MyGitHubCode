package iCaster.Security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilter implements Filter
{

	private String targetURL = "/index.jsf";

	public MyFilter()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void destroy()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException
	{
		// TODO Auto-generated method stub
		if (request instanceof HttpServletRequest)
		{
			String url = ((HttpServletRequest) request).getServletPath().toString();

			if (url.compareTo("/") == 0)
			{

				((HttpServletResponse) response).sendRedirect(((HttpServletRequest)
						request).getContextPath() + this.targetURL);

				return;
			}
		}

		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		targetURL = filterConfig.getInitParameter("targetURL"); 

	}

}
