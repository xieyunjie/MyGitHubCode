package iCaster.Util;

import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CurrentFacesContext
{
	@Produces
	public static FacesContext getFacesContext()
	{
		return FacesContext.getCurrentInstance();
	}

	public static ExternalContext getExternalContext()
	{
		return getFacesContext().getExternalContext();
	}

	public static HttpServletRequest getRequest()
	{
		return (HttpServletRequest) getExternalContext().getRequest();
	}

	public static HttpServletResponse getResponse()
	{
		return (HttpServletResponse) getExternalContext().getResponse();
	}

	public static HttpSession getSession()
	{
		return (HttpSession) getExternalContext().getSession(false);
	}

	public static Flash getFlash()
	{
		return getExternalContext().getFlash();
	}

}
