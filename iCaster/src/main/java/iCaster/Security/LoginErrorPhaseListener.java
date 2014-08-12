package iCaster.Security;

import iCaster.Util.CurrentFacesContext;
import iCaster.Util.LocaleUtil;

import javax.faces.application.FacesMessage;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.WebAttributes;

public class LoginErrorPhaseListener implements PhaseListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginErrorPhaseListener()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void afterPhase(PhaseEvent arg0)
	{
	}

	@SuppressWarnings("deprecation")
	@Override
	public void beforePhase(PhaseEvent event)
	{
		/*
		 * Exception e = (Exception)
		 * CurrentFacesContext.getExternalContext().getSessionMap().get(
		 * AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY
		 * );
		 */

		Exception e = (Exception) CurrentFacesContext.getExternalContext().getSessionMap().get(WebAttributes.AUTHENTICATION_EXCEPTION);

		if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException)
		{
			CurrentFacesContext.getFacesContext().addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, LocaleUtil.getLocaleMessage("loginfailure"), "1"));

		}
		if (e != null)
		{
			CurrentFacesContext.getExternalContext().getSessionMap().remove(WebAttributes.AUTHENTICATION_EXCEPTION);
		}

	}

	@Override
	public PhaseId getPhaseId()
	{
		// TODO Auto-generated method stub
		return PhaseId.RENDER_RESPONSE;
	}

}
