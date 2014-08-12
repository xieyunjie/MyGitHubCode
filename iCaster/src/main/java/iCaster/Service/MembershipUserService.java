package iCaster.Service;

import iCaster.Annotation.Service;
import iCaster.Entity.MembershipResource;
import iCaster.Entity.MembershipResourceAuthority;
import iCaster.Entity.MembershipRole;
import iCaster.Entity.MembershipRoleAuthority;
import iCaster.Entity.MembershipUser;
import iCaster.IRepository.IBaseRepository;
import iCaster.IRepository.IMembershipResourceAuthorityRepository;
import iCaster.IRepository.IMembershipResourceRepository;
import iCaster.IRepository.IMembershipRoleAuthorityRepository;
import iCaster.IRepository.IMembershipRoleRepository;
import iCaster.IRepository.IMembershipUserRepository;
import iCaster.IService.IMembershipUserService;
import iCaster.Model.UserLoginInfo;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Service 
@Stateless
public class MembershipUserService extends BaseService<MembershipUser> implements IMembershipUserService
{

	@Inject
	protected IMembershipUserRepository<MembershipUser> repository;
	@Inject
	protected IMembershipRoleRepository<MembershipRole> roleRepository;
	@Inject
	protected IMembershipRoleAuthorityRepository<MembershipRoleAuthority> roleAuthorityRepository;
	@Inject
	protected IMembershipResourceRepository<MembershipResource> resourceRepository;
	@Inject
	protected IMembershipResourceAuthorityRepository<MembershipResourceAuthority> resourceAuthorityRepository;

	@Override
	public IBaseRepository<MembershipUser> getRepository()
	{
		return this.repository;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public UserLoginInfo GetUserResourceAndAuthority(String userName)
	{
		// userResources = new HashSet<MembershipResource>(0);
		// userAuthorities = new HashSet<MembershipAuthority>(0);

		MembershipUser user = (MembershipUser) this.repository.getBy("username", userName);

		if (user == null)
		{
			return null;
		}

		UserLoginInfo userlogin = new UserLoginInfo();

		userlogin.setUser(user);

		Object roles = this.roleRepository.execNameQuery("MembershipRole.getRolesByUserUID", user.getUid());
		List userAuthorities, userResources;
		if (roles != null)
		{
			userlogin.setUserRoles((List<MembershipRole>) roles);

			// userAuthorities = (List<MembershipRoleAuthority>)
			// this.roleAuthorityRepository.execNameQuery("MembershipRoleAuthority.getRoleAuthorityByUserUID",
			// user.getUid());
			userAuthorities = (List<MembershipResourceAuthority>) this.resourceAuthorityRepository.execNameQuery("MembershipResourceAuthority.getResourceAuthByUserUID", user.getUid());
			userlogin.setUserAuthorities(userAuthorities);

			userResources = (List<MembershipResource>) this.resourceRepository.execNameQuery("MembershipRole.getResourceByUserUID", user.getUid());
			userlogin.setUserResources(userResources);

		}

		// List<MembershipRole> userRoles2 = (List<MembershipRole>)
		// this.userRepository.execNameQuery("getRolesByUserUID",
		// user.getUid());
		//
		// if (userRoles2 != null)
		// {
		// userRoles.addAll(userRoles2);
		// }
		//
		// // System.out.println(userRoles2.size());
		// MembershipRole role = null;
		// Set<MembershipRoleAuthority> roleAuthorities = null;
		//
		// for (MembershipUserRole membershipUserRole : userRoles2)
		// {
		// role = membershipUserRole.getMembershipRoleBean();
		// userRoles.add(role);
		// roleAuthorities = role.getMembershipRoleauthorities();
		// userAuthorities.addAll(roleAuthorities);
		// for (MembershipRoleAuthority membershipRoleAuthority :
		// roleAuthorities)
		// {
		// userResources.add(membershipRoleAuthority.getMembershipResourceauthority().getMembershipResource());
		// }
		// }

		return userlogin;
	}
}
