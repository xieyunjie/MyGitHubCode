package iCaster.IService;

import iCaster.Entity.MembershipResource;
import iCaster.Model.UserResourceAuthority;

public interface IMembershipResourceService extends IBaseService<MembershipResource>
{
	UserResourceAuthority GetUserResourceAndAuthorityByURL(String url);
}
