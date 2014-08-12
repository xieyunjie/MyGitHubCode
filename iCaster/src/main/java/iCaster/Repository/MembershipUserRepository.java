package iCaster.Repository; 

import iCaster.Annotation.Repository;
import iCaster.Entity.MembershipUser;
import iCaster.IRepository.IMembershipUserRepository;
 

@Repository 
public class MembershipUserRepository extends BaseRepository<MembershipUser> implements IMembershipUserRepository<MembershipUser>
{

	public MembershipUserRepository()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<MembershipUser> getClazz()
	{
		return MembershipUser.class;
	}

}