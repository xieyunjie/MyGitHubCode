package iCaster.Repository; 

import iCaster.Annotation.Repository;
import iCaster.Entity.MembershipRole;
import iCaster.IRepository.IMembershipRoleRepository;

@Repository
public class MembershipRoleRepository extends BaseRepository<MembershipRole> implements IMembershipRoleRepository<MembershipRole>
{

	@Override
	public Class<MembershipRole> getClazz()
	{
		return MembershipRole.class;
	}
}
