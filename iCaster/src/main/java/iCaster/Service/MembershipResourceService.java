package iCaster.Service;

import iCaster.Annotation.Service;
import iCaster.Entity.MembershipResource;
import iCaster.Entity.MembershipResourceAuthority;
import iCaster.IRepository.IBaseRepository;
import iCaster.IRepository.IMembershipResourceAuthorityRepository;
import iCaster.IRepository.IMembershipResourceRepository;
import iCaster.IService.IMembershipResourceService;
import iCaster.Model.UserResourceAuthority;
import iCaster.Model.UserResourceAuthorityType;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Service 
@Stateless
public class MembershipResourceService extends BaseService<MembershipResource> implements IMembershipResourceService 
{
	@Inject
	protected IMembershipResourceRepository<MembershipResource> repository;

	@Inject
	private IMembershipResourceAuthorityRepository<MembershipResourceAuthority> resourceAuthorityRepository;

	@Override
	public IBaseRepository<MembershipResource> getRepository()
	{
		return this.repository;
	}

	@Override
	public UserResourceAuthority GetUserResourceAndAuthorityByURL(String url)
	{

		MembershipResource resource = (MembershipResource) this.repository.getBy("url", url);

		if (resource != null)
		{
			UserResourceAuthority authority = new UserResourceAuthority(resource.getUid(), resource.getUrl(), UserResourceAuthorityType.Resource);
			return authority;
		}

		MembershipResourceAuthority recAuthority = (MembershipResourceAuthority) this.resourceAuthorityRepository.getBy("url", url);

		if (recAuthority != null)
		{

			UserResourceAuthority authority = new UserResourceAuthority(recAuthority.getUid(), recAuthority.getUrl(), UserResourceAuthorityType.ResourceAuthority);
			return authority;
		}

		return null;
	}

}
