package iCaster.WebService;

import java.util.List;

import iCaster.Entity.FrameworkCity;
import iCaster.IService.IFrameworkCityService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/cityservice")
@Produces(
{ "application/json" })
public class CityWebService
{

	@EJB
	private IFrameworkCityService cityService;

	@GET
	@Path("/")
	public List<FrameworkCity> getCities()
	{
		List<FrameworkCity> cities = this.cityService.query("");

		return cities;

	}

	@GET
	@Path("/{cityuid}")
	public FrameworkCity getCity(@PathParam(value = "cityuid") String cityUID)
	{
		FrameworkCity city = this.cityService.get(cityUID);
		
		return city;
	}
}
