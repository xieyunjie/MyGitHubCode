package com.balintimes.MMMS.IService;

import java.io.Serializable; 

import com.balintimes.MMMS.Model.UserResourceAuthority;

public interface IMembershipResourceService<T extends Serializable> extends IBaseService<T>
{  
	UserResourceAuthority GetUserResourceAndAuthorityByURL(String url);
}
