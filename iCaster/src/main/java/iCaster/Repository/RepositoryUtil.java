package iCaster.Repository; 

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class RepositoryUtil
{
	@PersistenceContext(name = "iCasterPersistenceContext", unitName = "iCasterPersistence")
	@Produces
	private EntityManager em;
}
