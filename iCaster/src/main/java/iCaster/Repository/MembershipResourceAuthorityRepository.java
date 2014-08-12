package iCaster.Repository; 

import iCaster.Annotation.Repository;
import iCaster.Entity.MembershipResourceAuthority;
import iCaster.IRepository.IMembershipResourceAuthorityRepository;
 
@Repository
public class MembershipResourceAuthorityRepository extends BaseRepository<MembershipResourceAuthority> implements IMembershipResourceAuthorityRepository<MembershipResourceAuthority>
{

	@Override
	public Class<MembershipResourceAuthority> getClazz()
	{
		return MembershipResourceAuthority.class;
	}

}
