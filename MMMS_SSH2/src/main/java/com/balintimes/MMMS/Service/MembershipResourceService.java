package com.balintimes.MMMS.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Service;

import com.balintimes.MMMS.Beans.*;
import com.balintimes.MMMS.IRepository.IBaseRepository;
import com.balintimes.MMMS.IRepository.IMembershipResourceAuthorityRepository;
import com.balintimes.MMMS.IService.IMembershipResourceService;
import com.balintimes.MMMS.Model.UserResourceAuthority;
import com.balintimes.MMMS.Model.UserResourceAuthorityType;
import com.balintimes.MMMS.Repository.MembershipResourceAuthorityRepository;

@Service("membershipResourceService")
@Transactional(value = TxType.REQUIRED)
public class MembershipResourceService extends BaseService<MembershipResource> implements IMembershipResourceService<MembershipResource>
{
	@Resource(name = "membershipResourceRepository")
	protected IBaseRepository<MembershipResource> repository;

	@Resource(name = "membershipResourceAuthorityRepository")
	private IMembershipResourceAuthorityRepository<MembershipResourceAuthority> resourceAuthorityRepository;

	@Override
	public IBaseRepository<MembershipResource> getRepository()
	{
		return this.repository;
	}

	@Override
	public UserResourceAuthority GetUserResourceAndAuthorityByURL(String url)
	{

		MembershipResource resource = this.repository.getBy("url", url);

		if (resource != null)
		{
			UserResourceAuthority authority = new UserResourceAuthority(resource.getUid(),resource.getUrl(),UserResourceAuthorityType.Resource);
			return authority;
		}
		
		MembershipResourceAuthority recAuthority = this.resourceAuthorityRepository.getBy("url", url);
		
		if (recAuthority!= null)
		{

			UserResourceAuthority authority = new UserResourceAuthority(recAuthority.getUid(),recAuthority.getUrl(),UserResourceAuthorityType.ResourceAuthority);
			return authority;
		}
		
		return null;
	}

}
