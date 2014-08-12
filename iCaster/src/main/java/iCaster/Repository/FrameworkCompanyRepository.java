package iCaster.Repository;

import iCaster.Annotation.Repository;
import iCaster.Entity.FrameworkCompany;
import iCaster.IRepository.IFrameworkCompanyRepository;

@Repository
public class FrameworkCompanyRepository extends BaseRepository<FrameworkCompany> implements IFrameworkCompanyRepository<FrameworkCompany>
{

	public FrameworkCompanyRepository()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<FrameworkCompany> getClazz()
	{
		return FrameworkCompany.class;
	}

}