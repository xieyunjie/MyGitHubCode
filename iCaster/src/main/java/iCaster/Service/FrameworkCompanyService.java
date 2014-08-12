package iCaster.Service;

import iCaster.Annotation.Service;
import iCaster.Entity.FrameworkCompany;
import iCaster.IRepository.IBaseRepository;
import iCaster.IRepository.IFrameworkCompanyRepository;
import iCaster.IService.IFrameworkCompanyService;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Service 
@Stateless
public class FrameworkCompanyService extends BaseService<FrameworkCompany> implements IFrameworkCompanyService
{

	@Inject
	protected IFrameworkCompanyRepository<FrameworkCompany> repository;

	@Override
	public IBaseRepository<FrameworkCompany> getRepository()
	{
		return this.repository;
	}

}
