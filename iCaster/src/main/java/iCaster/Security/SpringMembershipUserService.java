package iCaster.Security;

import iCaster.IService.IMembershipUserService;
import iCaster.Model.UserLoginInfo;

import javax.inject.Inject;
import javax.inject.Named;

public class SpringMembershipUserService
{
	@Inject
	private IMembershipUserService userService;

	public SpringMembershipUserService()
	{
		// TODO Auto-generated constructor stub
	}

	public UserLoginInfo GetUserResourceAndAuthority(String userName)
	{
		return this.userService.GetUserResourceAndAuthority(userName);
	}
}
