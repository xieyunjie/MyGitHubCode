package com.balintimes.MMMS.Model;

import java.io.Serializable;

public class UserResourceAuthority implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String uid;
	private String url;
	private UserResourceAuthorityType userResourceAuthorityType;

	public UserResourceAuthority(String UID, String URL, UserResourceAuthorityType authorityType)
	{
		this.uid = UID;
		this.url = URL;
		this.userResourceAuthorityType = authorityType;
	}

	public String getUid()
	{
		return uid;
	}

	public void setUid(String uid)
	{
		this.uid = uid;
	}

	public String getUrl()
	{
		return url;
	}

	public UserResourceAuthorityType getUserResourceAuthorityType()
	{
		return userResourceAuthorityType;
	}

	public void setUserResourceAuthorityType(UserResourceAuthorityType userResourceAuthorityType)
	{
		this.userResourceAuthorityType = userResourceAuthorityType;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

}
