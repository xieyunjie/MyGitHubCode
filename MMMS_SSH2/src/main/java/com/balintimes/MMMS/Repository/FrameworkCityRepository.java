package com.balintimes.MMMS.Repository;

import org.springframework.stereotype.Repository;

import com.balintimes.MMMS.Beans.FrameworkCity; 
import com.balintimes.MMMS.IRepository.IFrameworkCityRepository; 

@SuppressWarnings("unchecked")
@Repository("frameworkCityRepository")
public class FrameworkCityRepository extends BaseRepository<FrameworkCity> implements IFrameworkCityRepository<FrameworkCity>
{

	public FrameworkCityRepository()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<FrameworkCity> getClazz()
	{
		return FrameworkCity.class;
	}

}