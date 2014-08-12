package iCaster.Repository; 

import iCaster.Annotation.Repository;
import iCaster.Entity.MembershipRoleAuthority;
import iCaster.IRepository.IMembershipRoleAuthorityRepository;

@Repository
public class MembershipRoleAuthorityRepository extends BaseRepository<MembershipRoleAuthority> implements IMembershipRoleAuthorityRepository<MembershipRoleAuthority>
{

	@Override
	public Class<MembershipRoleAuthority> getClazz()
	{
		// TODO Auto-generated method stub
		return MembershipRoleAuthority.class;
	}

}
