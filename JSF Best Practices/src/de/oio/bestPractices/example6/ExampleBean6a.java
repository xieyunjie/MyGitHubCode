package de.oio.bestPractices.example6;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ExampleBean6a implements Serializable{

	private static final long serialVersionUID = 1L;

	private String input;

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
		
}
