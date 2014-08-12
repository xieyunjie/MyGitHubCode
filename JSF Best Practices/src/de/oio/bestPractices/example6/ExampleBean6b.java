package de.oio.bestPractices.example6;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ExampleBean6b implements Serializable{

	private static final long serialVersionUID = 1L;

	public ExampleBean6b(){
		
	}
	
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
		
}
