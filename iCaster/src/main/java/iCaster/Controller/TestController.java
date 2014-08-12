package iCaster.Controller;

import iCaster.Annotation.Controller;
import iCaster.Entity.FrameworkCity;
import iCaster.Entity.FrameworkCompany;
import iCaster.IService.IFrameworkCityService;
import iCaster.IService.IFrameworkCompanyService;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.ejb.EJB;

import org.reflections.Reflections;

@Controller
public class TestController extends BaseController
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3528937434229792070L;
	@EJB
	private IFrameworkCityService cityService;
	@EJB
	private IFrameworkCompanyService companyService;

	private String username;

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public void testInject()
	{
		// System.out.println("TestController.testInject()");
		// List<FrameworkCity> cityList = this.cityService.query("");
		//
		// if (cityList == null)
		// {
		// System.out.println("cityList is null");
		// }
		//
		// System.out.println("Success!!!!!");

		List<FrameworkCity> cityList = (List<FrameworkCity>) this.cityService.queryDataTuple("", null, 0, 3).data;

		if (cityList != null)
		{
			for (FrameworkCity frameworkCity : cityList)
			{
				System.out.println(frameworkCity.getName());
			}
		}

	}

	public void AddCity()
	{
		// FrameworkCity city = new FrameworkCity();
		//
		// UUID cityUuid = UUID.randomUUID();
		// city.setUid(cityUuid.toString());
		// city.setName("newCity");
		//
		// FrameworkCompany company = new FrameworkCompany();
		// company.setUid(UUID.randomUUID().toString());
		// company.setName("newCompany");
		// company.setFrameworkCity(city);
		// List<FrameworkCompany> companies = new
		// ArrayList<FrameworkCompany>(1);
		// companies.add(company);
		// city.setFrameworkCompanies(companies);
		// this.cityService.save(city);
		// company.setCityuid(cityUuid.toString());
		// this.cityService.SaveCityAndCompany(city, company);
		// this.cityService

		FrameworkCity city = new FrameworkCity();

		UUID cityUuid = UUID.randomUUID();
		city.setUid(cityUuid.toString());
		city.setName("newCity");

		FrameworkCompany company = new FrameworkCompany();
		company.setUid(UUID.randomUUID().toString());
		// company.setName("qwertyyuioplkjhgfdasccvbnmPIPIOIOIYTUUTGGkjjhhgfgfdfeerttyyuiooopopijjhgfdeertyyu");
		company.setName("qwqw");
		company.setCityUID(cityUuid.toString());

		this.cityService.SaveCityAndCompany(city, company);
	}

	public void UpdateCompanyCity()
	{
		// FrameworkCompany company = (FrameworkCompany)
		// this.companyService.get("aecba716-fde9-4370-a8e8-1851b0098642");
		//
		// FrameworkCity city = (FrameworkCity)
		// this.cityService.get("f2a4b49f-ba41-11e3-99cf-c86000a05d5f");
		//
		// company.setFrameworkCity(city);
		//
		// this.companyService.update(company);

		/*
		 * DataTuple<Integer, List<FrameworkCity>> dataTuple =
		 * this.cityService.queryDataTuple("", null, 0, 3);
		 * List<FrameworkCity> cityList = (List<FrameworkCity>) dataTuple.data;
		 * int count = dataTuple.count;
		 * System.out.println("######################   " + count);
		 * for (FrameworkCity frameworkCity : cityList)
		 * {
		 * System.out.println(frameworkCity.getName());
		 * }
		 */

		/*
		 * Reflections reflections = new Reflections("iCaster.Controller");
		 * Set<Class<? extends BaseController>> allClasses =
		 * reflections.getSubTypesOf(BaseController.class);
		 * 
		 * for (Class<? extends Object> cls : allClasses)
		 * {
		 * Method[] methods = cls.getDeclaredMethods();
		 * for (Method method : methods)
		 * {
		 * System.out.println(cls.getSimpleName() + "." + method.getName());
		 * }
		 * }
		 */

		List<FrameworkCity> list = this.cityService.GetCityTwice();
		for (FrameworkCity frameworkCity : list)
		{
			System.out.println(frameworkCity.getName());
		}

	}

}
