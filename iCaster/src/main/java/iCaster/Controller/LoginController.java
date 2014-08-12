package iCaster.Controller;

import iCaster.Util.CurrentFacesContext;

import java.io.IOException;

import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

 
@Named
@RequestScoped
public class LoginController  extends BaseController
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginController()
	{
		// TODO Auto-generated constructor stub
		
		System.out.println("构造函数！");
	}

	public String doLogin() throws IOException, ServletException
	{
		ExternalContext context = CurrentFacesContext.getExternalContext();

		RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_check");

		dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());

		CurrentFacesContext.getFacesContext().responseComplete();

		return null;
	}
}
