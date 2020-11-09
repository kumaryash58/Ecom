package com.techment.SwaggerDemo.Form;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.techment.SwaggerDemo.POJO.City;
import com.techment.SwaggerDemo.POJO.Country;
import com.techment.SwaggerDemo.POJO.State;

public class AddressForm {
	

	 private String addressLine1;
	
	 private String addressLine2;
	 
	 private String zipCode;
	 
     private Country country;
    
     private State state;

     private City city;

	public AddressForm(String addressLine1, String addressLine2, String zipCode, Country country, State state, City city) {
        this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.zipCode = zipCode;
		this.country = country;
		this.state = state;
		this.city = city;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
  

}
