package iCaster.Controller;
 
import iCaster.Annotation.Controller;
import iCaster.Model.Car;
import iCaster.Util.CurrentFacesContext;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.primefaces.event.SelectEvent;

@Controller
public class HomeController extends BaseController
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static String[] colors;

	private final static String[] manufacturers;

	static
	{
		colors = new String[10];
		colors[0] = "Black";
		colors[1] = "White";
		colors[2] = "Green";
		colors[3] = "Red";
		colors[4] = "Blue";
		colors[5] = "Orange";
		colors[6] = "Silver";
		colors[7] = "Yellow";
		colors[8] = "Brown";
		colors[9] = "Maroon";

		manufacturers = new String[10];
		manufacturers[0] = "Mercedes";
		manufacturers[1] = "BMW";
		manufacturers[2] = "Volvo";
		manufacturers[3] = "Audi";
		manufacturers[4] = "Renault";
		manufacturers[5] = "Opel";
		manufacturers[6] = "Volkswagen";
		manufacturers[7] = "Chrysler";
		manufacturers[8] = "Ferrari";
		manufacturers[9] = "Ford";
	}

	private List<Car> carsSmall;
	private Car selectedCar;

	public HomeController()
	{
		carsSmall = new ArrayList<Car>();

		populateRandomCars(carsSmall, 9);
	}

	@PostConstruct
	public void initResource()
	{
		Object object = CurrentFacesContext.getExternalContext().getFlash().get("selectedcar");
		if (object != null)
		{
			this.selectedCar = (Car) object;
		}
	}

	private void populateRandomCars(List<Car> list, int size)
	{
		for (int i = 0; i < size; i++)
			list.add(new Car(getRandomModel(), getRandomYear(), getRandomManufacturer(), getRandomColor()));
	}

	public List<Car> getCarsSmall()
	{
		return carsSmall;
	}

	private int getRandomYear()
	{
		return (int) (Math.random() * 50 + 1960);
	}

	private String getRandomColor()
	{
		return colors[(int) (Math.random() * 10)];
	}

	private String getRandomManufacturer()
	{
		return manufacturers[(int) (Math.random() * 10)];
	}

	private String getRandomModel()
	{
		return UUID.randomUUID().toString().substring(0, 8);
	}

	public Car getSelectedCar()
	{
		return selectedCar;
	}

	public void setSelectedCar(Car selectedCar)
	{
		this.selectedCar = selectedCar;
	}

	public String AddNewCarView()
	{
		// String typeString = (String)
		// event.getComponent().getAttributes().get("actionType");
		// CurrentFacesContext.getExternalContext().getFlash().put("selectedcar",
		// this.selectedCar);

		return "addnewcar?actionType=Create";
	}

	public String UpdateCar()
	{
		System.out.println(this.selectedCar.getModel());
		System.out.println(this.selectedCar.getManufacturer());

		return "home";
	}

	public String UpdateCarView()
	{

		CurrentFacesContext.getExternalContext().getFlash().put("selectedcar", this.selectedCar);

		return "modify";
	}

	public String DeleteCarView()
	{
		return "deletecar?faces-redirect=true&uid=9999";
	}

	public void onRowSelect(SelectEvent event)
	{
		this.selectedCar = (Car) event.getObject();

	}
}
