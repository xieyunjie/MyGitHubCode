package de.oio.bestPractices.example7;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

@ManagedBean
@RequestScoped
public class FlashExampleBean implements Serializable{

	private static final long serialVersionUID = -4401270348003254611L;

	@ManagedProperty("#{flash}")
	private Flash flash;
	
	public String getInputFromFlash(){
		String inputText  = (String) flash.get("inputText");
		
		flash.keep("inputText");
		return inputText;
	}

	public void setFlash(Flash flash) {
		this.flash = flash;
	}

	public Flash getFlash() {
		return flash;
	}
	
}
