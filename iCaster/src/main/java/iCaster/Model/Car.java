package iCaster.Model;

public class Car
{
	public Car()
	{ 
	}
	public Car(String model, int i, String manufacturer, String color)
	{
		this.model = model;
		this.year = i;
		this.manufacturer = manufacturer;
		this.color = color;
	}

	private String model;
	private int year;
	private String manufacturer;
	private String color;

	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public int getYear()
	{
		return year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public String getManufacturer()
	{
		return manufacturer;
	}

	public void setManufacturer(String manufacturer)
	{
		this.manufacturer = manufacturer;
	}

	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
	}

	@Override
	public String toString()
	{
		return model + "#" + color + "#" + manufacturer + "#" + color;
	}
}
