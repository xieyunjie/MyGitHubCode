package com.balintimes.MMMS.Controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.balintimes.MMMS.IService.IMembershipUserService;

@Controller
@Scope("prototype")
public class LoginController
{

	public LoginController()
	{
		// TODO Auto-generated constructor stub
	}

	public String loginView()
	{
		return "login";
	}

	public String indexView()
	{
		return "index";
	}

	public String index2View()
	{
		return "index2";
	}

	public String adminView()
	{
		return "admin";
	}

	public String execError()
	{
		IMembershipUserService usersService = null;

		usersService.get(19);

		return "error";
	}

	private String actionName;

	public String getActionName()
	{
		return actionName;
	}

	public void setActionName(String actionName)
	{
		this.actionName = actionName;
	}

	public void indexAdd()
	{
		this.actionName = "indexAdd";
	}

	public void indexEdit()
	{
		this.actionName = "indexEdit";
	}

	public void indexDel()
	{
		this.actionName = "indexDel";
	}
}
