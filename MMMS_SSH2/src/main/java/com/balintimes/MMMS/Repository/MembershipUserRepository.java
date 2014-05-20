package com.balintimes.MMMS.Repository;

import org.springframework.stereotype.Repository;

import com.balintimes.MMMS.Beans.MembershipUser;
import com.balintimes.MMMS.IRepository.IMembershipUserRepository; 
@SuppressWarnings("unchecked")
@Repository("membershipUserRepository")
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