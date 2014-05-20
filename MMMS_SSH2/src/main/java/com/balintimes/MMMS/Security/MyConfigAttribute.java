package com.balintimes.MMMS.Security;

import org.springframework.security.access.ConfigAttribute;

import com.balintimes.MMMS.Model.UserResourceAuthority;
import com.balintimes.MMMS.Model.UserResourceAuthorityType;

public class MyConfigAttribute  extends UserResourceAuthority implements ConfigAttribute
{ 
	public MyConfigAttribute(String UID, String URL, UserResourceAuthorityType authorityType)
	{
		super(UID, URL, authorityType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getAttribute()
	{ 
		return this.getUid() + this.getUrl()+this.getUserResourceAuthorityType();
		// TODO Auto-generated method stub
//		return null;
	}

}
