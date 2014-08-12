package de.oio.bestPractices.example5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import de.oio.bestPractices.pojo.Customer;

@ManagedBean(name="addressTableBeanExample5")
@ViewScoped
public class ExampleBean5 implements Serializable{

	private static final long serialVersionUID = 1L;

	private transient ListDataModel<Customer> data = new ListDataModel<Customer>() ;
	
	private Customer selected;

	public ExampleBean5(){

		// create example data model
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer("Homer","Simpson",80085));
		customers.add(new Customer("Barney","Gumble",83321));
		customers.add(new Customer("Ned","Flanders",81813));
		this.data.setWrappedData(customers);

	}
	
	public Customer getSelected() {
		return selected;
	}

	public void setSelected(Customer selected) {
		this.selected = selected;
	}

	public ListDataModel<Customer> getData() {
		return data;
	}

	public void setData(ListDataModel<Customer> data) {
		this.data = data;
	}
	
	public String select(){
		this.selected = data.getRowData();
		return "";
	}
		
}
