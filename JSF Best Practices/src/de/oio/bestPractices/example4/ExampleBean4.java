package de.oio.bestPractices.example4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import de.oio.bestPractices.pojo.Customer;

@ManagedBean(name="addressTableBeanExample4")
@ViewScoped
public class ExampleBean4 implements Serializable{

	private static final long serialVersionUID = 1L;

	private transient List<Customer> data = new ArrayList<Customer>() ;
	
	private Customer selected;

	public ExampleBean4(){

		// create example data model
		data.add(new Customer("Homer","Simpson",80085));
		data.add(new Customer("Barney","Gumble",83321));
		data.add(new Customer("Ned","Flanders",81813));

	}
	
	public void selectionListener(ActionEvent event){
		Customer customer = (Customer) event.getComponent().getAttributes().get("selection");
		
		this.selected = customer;
	}
	
	public Customer getSelected() {
		return selected;
	}

	public void setSelected(Customer selected) {
		this.selected = selected;
	}

	public List<Customer> getData() {
		return data;
	}

	public void setData(List<Customer> data) {
		this.data = data;
	}
		
}
