/**
 * 
 */
package com.balintimes.Test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.balintimes.MMMS.Beans.*;
import com.balintimes.MMMS.IService.IFrameworkCityService;
import com.balintimes.MMMS.IService.IMembershipUserService;

/**
 * @author AlexXie
 * 
 */
public class RepositoryTest
{

	// /**
	// *
	// */
	// public RepositoryTest()
	// {
	// // TODO Auto-generated constructor stub
	// }
	//

	@Test
	public void testRepository()
	{
//		@SuppressWarnings("resource")
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//		IMembershipUserService userService = ctx.getBean("membershipUserService", IMembershipUserService.class);
//
//		Set<MembershipResource> userResources = new HashSet<MembershipResource>(0);
//		Set<MembershipRoleAuthority> userAuthorities = new HashSet<MembershipRoleAuthority>(0);
//		Set<MembershipRole> userRoles = new HashSet<MembershipRole>(0);
//		MembershipUser user = userService.GetUserResourceAndAuthority("admin", userResources, userAuthorities, userRoles);
//
//		System.out.println("resource");
//		for (MembershipResource resource : userResources)
//		{
//			System.out.println(resource.getUid());
//		}
//		System.out.println("authority");
//		for (MembershipRoleAuthority membershipAuthority : userAuthorities)
//		{
//			System.out.println(membershipAuthority.getId());
//		}
//
//		System.out.println("roles");
//		for (MembershipRole role : userRoles)
//		{
//			System.out.println(role.getUid());
//		}
	}

	@Test
	public void CityRepository()
	{
//		@SuppressWarnings("resource")
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//		IFrameworkCityService cityService = ctx.getBean("frameworkCityService", IFrameworkCityService.class);
//
//		Set<FrameworkCompany> companies = new HashSet<FrameworkCompany>(0);
//		FrameworkCity city = cityService.getCity("f2a4b49f-ba41-11e3-99cf-c86000a05d5f", companies);
//		for (FrameworkCompany frameworkCompany : companies)
//		{
//			System.out.println(frameworkCompany.getName());
//		}

	}

	// @Test
	// public void testRepository()
	// {
	// @SuppressWarnings("resource")
	// ApplicationContext ctx = new ClassPathXmlApplicationContext(
	// "applicationContext.xml");
	//
	// IResourcesService ResourcesSvc = ctx.getBean("resourcesService",
	// IResourcesService.class);
	//
	// Serializable userId = 9;
	// Resources user = (Resources) ResourcesSvc.getBy("URL",
	// "/sp/loginView.do");
	//
	// if (user == null)
	// {
	// System.out.printf("== user is null ===");
	// }
	// else
	// {
	// System.out.printf(user.toString());
	// }
	//
	// }
	//
	// @Test
	// public void getUserClass()
	// {
	//
	// System.out.printf(UserBean.class.toString());
	// }
	//
	// @Test
	// public void testNameQuery()
	// {
	// @SuppressWarnings("resource")
	// ApplicationContext ctx = new ClassPathXmlApplicationContext(
	// "applicationContext.xml");
	//
	// IUserService userService = ctx.getBean("userService",
	// IUserService.class);
	//
	// List<Object> params = new ArrayList<>();
	// params.add("yunjie.xie");
	// // List<UserBean> list = (List<UserBean>) userService.execNameQuery(
	// // "findUserByName", params);
	// List<UserBean> list = (List<UserBean>) userService.execNameQuery(
	// "findUserByName", params);
	//
	// if (list != null)
	// {
	// for (UserBean userBean : list)
	// {
	// System.out.printf(userBean.getName());
	// }
	// }
	// }
	//
	// @Test
	// public void saveUser()
	// {
	// @SuppressWarnings("resource")
	// ApplicationContext ctx = new ClassPathXmlApplicationContext(
	// "applicationContext.xml");
	//
	// IUserService userService = ctx.getBean("userService",
	// IUserService.class);
	//
	// UserBean userBean = new UserBean();
	// // userBean.setId(10);
	// userBean.setName("yunjie.xie");
	// userBean.setAge(30);
	//
	// userService.save(userBean);
	//
	// }
}
