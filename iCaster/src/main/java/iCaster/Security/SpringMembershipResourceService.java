package iCaster.Security;

import iCaster.Entity.MembershipResource;
import iCaster.IService.IMembershipResourceService;
import iCaster.Model.UserResourceAuthority;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

public class SpringMembershipResourceService
{
	@Inject
	private IMembershipResourceService resourceService;

	public SpringMembershipResourceService()
	{
		// TODO Auto-generated constructor stub
	}

	public List<MembershipResource> loadResource()
	{
		return this.resourceService.query("");
	}

	public UserResourceAuthority GetUserResourceAndAuthorityByURL(String requestUrl)
	{
		return this.resourceService.GetUserResourceAndAuthorityByURL(requestUrl);
	}

}
