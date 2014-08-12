package iCaster.Repository;

import iCaster.Annotation.Repository;
import iCaster.Entity.FrameworkCity;
import iCaster.IRepository.IFrameworkCityRepository;

import java.util.List;

import javax.persistence.Query;

@Repository
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

	@Override
	public List<FrameworkCity> GetCityList()
	{
		String sqlString = "FROM FrameworkCity WHERE name = ?1";

		Query query = getEntityManager().createQuery(sqlString);
		query.setParameter(1, "newCity");
		return (List<FrameworkCity>) query.getResultList();
	}

}