package com.techment.SwaggerDemo.Form;

import java.util.List;

import com.techment.SwaggerDemo.POJO.State;

public class CountryForm {
	private String countryName;
    private List<State> states;
	public CountryForm(String countryName, List<State> states) {
		super();
		this.countryName = countryName;
		this.states = states;
	}
	
	
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public List<State> getStates() {
		return states;
	}
	public void setStates(List<State> states) {
		this.states = states;
	}
    
    

}
