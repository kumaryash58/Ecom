package com.techment.SwaggerDemo.Controller;

import org.springframework.hateoas.ResourceSupport;

public class AddressDto extends ResourceSupport {

	private String addressLine1;
	private String addressLine2;
	private String zipCode;
	
	private long countryId;
	private long stateId;
	private long cityId;
	
	protected AddressDto() {}

	public AddressDto(String addressLine1, String addressLine2, String zipCode, long countryId, long stateId,
			long cityId) {

		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.zipCode = zipCode;
		this.countryId = countryId;
		this.stateId = stateId;
		this.cityId = cityId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}


	public String getAddressLine2() {
		return addressLine2;
	}



	public String getZipCode() {
		return zipCode;
	}



	public long getCountryId() {
		return countryId;
	}



	public long getStateId() {
		return stateId;
	}



	public long getCityId() {
		return cityId;
	}



	
}
