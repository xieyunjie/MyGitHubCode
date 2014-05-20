package com.balintimes.MMMS.IService;

import java.io.Serializable;
import java.util.Set;
  
import com.balintimes.MMMS.Beans.FrameworkCity;
import com.balintimes.MMMS.Beans.FrameworkCompany; 
public interface IFrameworkCityService<T extends Serializable> extends IBaseService<T>
{ 
	
	FrameworkCity getCity(String cityUID ,Set<FrameworkCompany> companies);
}
