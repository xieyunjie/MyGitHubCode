package com.balintimes.MMMS.Repository;

import org.springframework.stereotype.Repository;

import com.balintimes.MMMS.Beans.MembershipResource;
import com.balintimes.MMMS.IRepository.IMembershipUserRepository; 

@SuppressWarnings("unchecked")
@Repository("membershipResourceRepository")
public class MembershipResourceRepository extends BaseRepository<MembershipResource> implements IMembershipUserRepository<MembershipResource>
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