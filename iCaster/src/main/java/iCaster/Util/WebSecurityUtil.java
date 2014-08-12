package iCaster.Util;

import iCaster.Security.WebUserDetails;

import org.springframework.security.core.context.SecurityContextHolder;

public class WebSecurityUtil
{
	public static WebUserDetails getUserDetails()
	{
		return (WebUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	}
}
