package de.oio.bestPractices.example1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import de.oio.bestPractices.pojo.Address;


@ManagedBean(name="adressTableBeanExample1")
@ViewScoped
public class AddressTableBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private List<Address> addresses = new ArrayList<Address>();
	
	private Address selected;

	public AddressTableBean() {

			// create some data for the table
			addresses.add(new Address("Homer", "742 Evergreen Terrace 1", "1094", "Springfield"));
			addresses.add(new Address("Marge", "742 Evergreen Terrace 2", "1094", "Springfield"));
			addresses.add(new Address("Bart", "742 Evergreen Terrace 3", "1094", "Springfield"));
			addresses.add(new Address("Lisa", "742 Evergreen Terrace 4", "1094", "Springfield"));
			addresses.add(new Address("Maggie", "742 Evergreen Terrace 5", "1094", "Springfield"));
		
	}
	
	public String delete(){
		addresses.remove(selected);
		return "";
	}
	
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> adresses) {
		this.addresses = adresses;
	}
	
	public Address getSelected() {
		return selected;
	}

	public void setSelected(Address selected) {
		this.selected = selected;
	}
	

}
