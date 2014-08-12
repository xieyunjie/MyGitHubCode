package iCaster.Security;

import iCaster.Model.UserResourceAuthority;
import iCaster.Model.UserResourceAuthorityType;

import org.springframework.security.access.ConfigAttribute;

public class WebConfigAttribute extends UserResourceAuthority implements ConfigAttribute
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WebConfigAttribute(String UID, String URL, UserResourceAuthorityType authorityType)
	{
		super(UID, URL, authorityType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getAttribute()
	{
		return this.getUid() + this.getUrl() + this.getUserResourceAuthorityType();
		// TODO Auto-generated method stub
		// return null;
	}
}
