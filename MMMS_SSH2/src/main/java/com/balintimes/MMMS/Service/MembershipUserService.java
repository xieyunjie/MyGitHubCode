package com.balintimes.MMMS.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import org.springframework.stereotype.Service;

import com.balintimes.MMMS.Beans.*;
import com.balintimes.MMMS.IRepository.IBaseRepository;
import com.balintimes.MMMS.IService.IMembershipUserService;

@Service("membershipUserService")
@Transactional(value = TxType.REQUIRED)
public class MembershipUserService extends BaseService<MembershipUser> implements IMembershipUserService<MembershipUser>
{
	@Resource(name = "membershipUserRepository")
	protected IBaseRepository<MembershipUser> repository;

	@Override
	public IBaseRepository<MembershipUser> getRepository()
	{
		return this.repository;
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public MembershipUser GetUserResourceAndAuthority(String userName, Set<MembershipResource> userResources, Set<MembershipRoleAuthority> userAuthorities, Set<MembershipRole> userRoles)
	{
		// userResources = new HashSet<MembershipResource>(0);
		// userAuthorities = new HashSet<MembershipAuthority>(0);

		MembershipUser user = this.repository.getBy("username", userName);

		if (user == null)
		{
			return null;
		}

		Set<MembershipUserRole> userRoles2 = user.getMembershipUserroles();
		System.out.println(userRoles2.size());
		MembershipRole role = null;
		Set<MembershipRoleAuthority> roleAuthorities = null;

		for (MembershipUserRole membershipUserRole : userRoles2)
		{
			role = membershipUserRole.getMembershipRoleBean();
			userRoles.add(role);
			roleAuthorities = role.getMembershipRoleauthorities();
			userAuthorities.addAll(roleAuthorities);
			for (MembershipRoleAuthority membershipRoleAuthority : roleAuthorities)
			{
				userResources.add(membershipRoleAuthority.getMembershipResourceauthority().getMembershipResource());
			}
		}

		return user;
	}

}
