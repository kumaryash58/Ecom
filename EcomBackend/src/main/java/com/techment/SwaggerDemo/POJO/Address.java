package com.techment.SwaggerDemo.POJO;



import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="tbl_address")
public class Address {
	 @Id
	 @Column(name="pk_address")
	 @GeneratedValue(strategy = GenerationType.AUTO)
     private long id;
     
	 @NotNull(message = "address_line1 not be null")
	 @Column(name="address_line1")
	 private String addressLine1;
	 
	
	 @Column(name="address_line2")
	 private String addressLine2;
	 
	 @NotNull(message = "zip_code not be null")
	 @Column(name = "zip_code")
	 private String zipCode;
	 

     @OneToOne
     @JoinColumn(name="fk_country")
     private Country country;
     
	 
	
     @OneToOne
     @JoinColumn(name = "fk_state")
     private State state;
     
	 

     @OneToOne
     @JoinColumn(name="fk_city")
     private City city;
     
	 
     @Column(name = "created_at")
     private Timestamp createdAt;

     @Column(name = "updated_at")
     private Timestamp updatedAt;

     @Column(name = "created_by")
     private String createdBy;

     @Column(name = "updated_by")
     private String updatedBy;
     
     
     
	protected Address() {
		
	}
	
	//Create Address
	public Address(@NotNull(message = "address_line1 not be null") String addressLine1, String addressLine2,
			@NotNull(message = "zip_code not be null") String zipCode, Country country, State state, City city,
			Timestamp timestamp, String createdBy) {
	
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.zipCode = zipCode;
		this.country = country;
		this.state = state;
		this.city = city;
		this.createdAt = timestamp;
		this.createdBy = createdBy;
	}

//Update Address
	public Address(@NotNull(message = "address_line1 not be null") String addressLine1, String addressLine2,
			@NotNull(message = "zip_code not be null") String zipCode, Country country, State state, City city,
			Timestamp createdAt, Timestamp updatedAt, String createdBy, String updatedBy) {
	
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.zipCode = zipCode;
		this.country = country;
		this.state = state;
		this.city = city;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}




//getter setter
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
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


	public Timestamp getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}


	public Timestamp getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}



}
