package com.balintimes.MMMS.Service;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Service;

import com.balintimes.MMMS.Beans.*;
import com.balintimes.MMMS.IRepository.IBaseRepository;
import com.balintimes.MMMS.IService.IFrameworkCityService;

@Service("frameworkCityService")
@Transactional(value = TxType.REQUIRED)
public class FrameworkCityService extends BaseService<FrameworkCity> implements IFrameworkCityService<FrameworkCity>
{
	@Resource(name = "frameworkCityRepository")
	protected IBaseRepository<FrameworkCity> repository;

	@Override
	public IBaseRepository<FrameworkCity> getRepository()
	{
		return this.repository;
	}

	public FrameworkCity getCity(String cityUID,Set<FrameworkCompany> companies)
	{ 
		
		FrameworkCity city = this.repository.getBy("UID", cityUID);
		Set<FrameworkCompany> com = city.getFrameworkCompanies();
		
		for (FrameworkCompany frameworkCompany : com)
		{
			companies.add(frameworkCompany);  
		} 
		
		return city;
	}

}
