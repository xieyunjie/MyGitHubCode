package iCaster.Controller;

import iCaster.Annotation.Controller;
import iCaster.Model.Car;

import javax.annotation.PostConstruct;

@Controller
public class ModifyCarController  extends BaseController
{ 

	/**
	 * 
	 */
	private static final long serialVersionUID = 5832632713603783135L;

	private String actionString = "ssssssssssss";

	private Car modifyCar;

	public Car getModifyCar()
	{
		return modifyCar;
	}

	public void setModifyCar(Car modifyCar)
	{
		this.modifyCar = modifyCar;
	}

	public ModifyCarController()
	{
		// System.out.println(modifyCar.toString());
		System.out.println(strTest.toString());
	}

	@PostConstruct
	public void initResource()
	{
		System.out.println(strTest.toString());
		this.modifyCar = new Car();
	}

	public String getStrTest()
	{
		return strTest;
	}

	public void setStrTest(String strTest)
	{
		this.strTest = strTest;

		this.modifyCar = new Car("", 0, this.strTest, "red");
		// this.modifyCar.setModel(strTest);
		// this.modifyCar.setColor("red");

		System.out.println("strTest is  ##   " + this.strTest);
	}

	private String strTest = "12345";

	public void PrintStrTest()
	{
		System.out.println(strTest.toString());
	}

	public String getActionString()
	{
		return actionString;
	}

	public void setActionString(String actionString)
	{
		this.actionString = actionString;
	}

	public String Save()
	{
//		System.out.println("CREATE NEW CAR: " );
		if (this.actionString == "Create")
		{
			System.out.println("CREATE NEW CAR: " + this.modifyCar.toString());
		}
		else
		{
			System.out.println("UPDATE CAR: " + this.modifyCar.toString());
		}

		return "home";
	}
}
