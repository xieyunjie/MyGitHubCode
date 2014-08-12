package iCaster.IRepository;
 
import java.io.Serializable;
import java.util.List;

public interface IFrameworkCityRepository<T extends Serializable> extends
		IBaseRepository<T>
{

	List<T> GetCityList();
}
