package com.techment.SwaggerDemo.Form;

import java.util.List;

import com.techment.SwaggerDemo.POJO.City;

public class StateForm {

	
	private String stateName;
	
	private List<City> cities;
	
	protected StateForm() {
		
	}

	public StateForm(String stateName, List<City> cities) {
		super();
		this.stateName = stateName;
		this.cities = cities;
	}



	public String getStateName() {
		return stateName;
	}



	public void setStateName(String stateName) {
		this.stateName = stateName;
	}



	public List<City> getCities() {
		return cities;
	}



	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
	
}
