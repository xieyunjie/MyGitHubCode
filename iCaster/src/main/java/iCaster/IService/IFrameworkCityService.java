package iCaster.IService;

import iCaster.Entity.FrameworkCity;
import iCaster.Entity.FrameworkCompany;

import java.util.List;
import java.util.Set;
 

public interface IFrameworkCityService extends IBaseService<FrameworkCity>
{

	FrameworkCity getCity(String cityUID, Set<FrameworkCompany> companies);

	void SaveCityAndCompany(FrameworkCity city, FrameworkCompany company);
	
	List<FrameworkCity> GetCityTwice();
}
