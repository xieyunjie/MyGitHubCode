package iCaster.Service;

import iCaster.Annotation.Service;
import iCaster.Entity.FrameworkCity;
import iCaster.Entity.FrameworkCompany;
import iCaster.IRepository.IBaseRepository;
import iCaster.IRepository.IFrameworkCityRepository;
import iCaster.IRepository.IFrameworkCompanyRepository;
import iCaster.IService.IFrameworkCityService;

import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import org.jboss.logging.annotations.Transform.TransformType;

@Service
@Stateless
public class FrameworkCityService extends BaseService<FrameworkCity> implements IFrameworkCityService
{
	// @Resource(name = "frameworkCityRepository")
	// protected IBaseRepository<FrameworkCity> repository;

	@Inject
	protected IFrameworkCityRepository<FrameworkCity> repository;
	@Inject
	protected IFrameworkCompanyRepository<FrameworkCompany> companyRep;

	@Override
	public IBaseRepository<FrameworkCity> getRepository()
	{
		return this.repository;
	}

	public FrameworkCity getCity(String cityUID, Set<FrameworkCompany> companies)
	{

		FrameworkCity city = (FrameworkCity) this.repository.getBy("UID", cityUID);
		// List<FrameworkCompany> com = city.getFrameworkCompanies();
		//
		// for (FrameworkCompany frameworkCompany : com)
		// {
		// companies.add(frameworkCompany);
		// }

		return city;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void SaveCityAndCompany(FrameworkCity city, FrameworkCompany company)
	{
		this.repository.save(city);
		this.companyRep.save(company);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<FrameworkCity> GetCityTwice()
	{

		

//		this.repository.query("name = ?1", "newCity");
//		this.repository.query("name = ?1", "newCity");
//		this.repository.query("name = ?1", "newCityx");
//		this.repository.query("name = ?1", "newCityy");
		
//		this.repository.get("f2a4b49f-ba41-11e3-99cf-c86000a05d5f");
//		this.repository.get("cde45789-be1f-44d8-8bee-0b2a102ce80f");
//		this.repository.get("43169eac-3ca5-4374-81fc-752ef37adef6");
//		this.repository.get("08953132-6537-477f-a571-5ab2812192dc");
//		
//		this.repository.query("");
//		
//		this.repository.get("f2a4b49f-ba41-11e3-99cf-c86000a05d51");
//		this.repository.get("f2a4b49f-ba41-11e3-99cf-c86000a05d52");
//		this.repository.get("f2a4b49f-ba41-11e3-99cf-c86000a05d53");
		
		
//		this.repository.getBy("name", "newCity");
//		this.repository.getBy("name", "newCity");
//		this.repository.getBy("name", "newCity");
//		this.repository.query("name = ?1", "newCity");
//		this.repository.query("name = ?1", "newCity");
//		this.repository.query("name = ?1", "newCity");
//		this.repository.query("name = ?1", "newCity");
//		this.repository.query("name = ?1", "newCity");

		List<FrameworkCity> list = this.repository.query("");
		// List<FrameworkCity> list = this.repository.GetCityList();
		
		System.out.println("###################################################");
		
		this.companyRep.query("name = ?1","百骏");
		this.companyRep.query("name = ?1","百骏");
		this.companyRep.query("");
		FrameworkCompany company = this.companyRep.get("027bb25b-ba42-11e3-99cf-c86000a05d5f");
//		company.setName("百骏X"); 
//		this.companyRep.save(company);
		FrameworkCompany company2 = this.companyRep.get("027bb25b-ba42-11e3-99cf-c86000a05d5f");
		
		System.out.println( " the company2 name is :" + company2.getName());


		return list;

	}

}
