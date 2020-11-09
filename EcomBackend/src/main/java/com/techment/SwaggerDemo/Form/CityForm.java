package com.techment.SwaggerDemo.Form;

public class CityForm {

	
	private String cityName;
	
	protected CityForm() {
		
	}

	public CityForm(String cityName) {
		super();
		this.cityName = cityName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
	
}
