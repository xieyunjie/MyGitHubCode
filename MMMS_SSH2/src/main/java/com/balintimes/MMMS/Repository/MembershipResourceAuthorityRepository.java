package com.balintimes.MMMS.Repository;

import org.springframework.stereotype.Repository;

import com.balintimes.MMMS.Beans.MembershipResourceAuthority;
import com.balintimes.MMMS.IRepository.IMembershipResourceAuthorityRepository;

@SuppressWarnings("unchecked")
@Repository("membershipResourceAuthorityRepository")
public class MembershipResourceAuthorityRepository extends BaseRepository<MembershipResourceAuthority> implements IMembershipResourceAuthorityRepository<MembershipResourceAuthority>
{

	@Override
	public Class<MembershipResourceAuthority> getClazz()
	{ 
		return MembershipResourceAuthority.class;
	}

}
