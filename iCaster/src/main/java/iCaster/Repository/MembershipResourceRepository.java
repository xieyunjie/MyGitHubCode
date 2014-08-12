package iCaster.Repository; 

import iCaster.Annotation.Repository;
import iCaster.Entity.MembershipResource;
import iCaster.IRepository.IMembershipResourceRepository;
 
 
@Repository 
public class MembershipResourceRepository extends BaseRepository<MembershipResource> implements IMembershipResourceRepository<MembershipResource>
{

	public MembershipResourceRepository()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<MembershipResource> getClazz()
	{
		return MembershipResource.class;
	}

}