package de.oio.bestPractices.example3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import de.oio.bestPractices.pojo.Address;


@ManagedBean(name="addressTableBeanExample3")
@ViewScoped
public class AddressTableBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private List<Address> addresses = new ArrayList<Address>();
	
	public AddressTableBean() {

			// create some data for the table
			addresses.add(new Address("Homer", "742 Evergreen Terrace 1", "1094", "Springfield"));
			addresses.add(new Address("Marge", "742 Evergreen Terrace 2", "1094", "Springfield"));
			addresses.add(new Address("Bart", "742 Evergreen Terrace 3", "1094", "Springfield"));
			addresses.add(new Address("Lisa", "742 Evergreen Terrace 4", "1094", "Springfield"));
			addresses.add(new Address("Maggie", "742 Evergreen Terrace 5", "1094", "Springfield"));
		
	}
	
	public void  delete(ActionEvent event){
		
		Address selected = (Address) event.getComponent().getAttributes().get("selected");
		
		addresses.remove(selected);
		
	}
	
	
	
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> adresses) {
		this.addresses = adresses;
	}
	
	

}
