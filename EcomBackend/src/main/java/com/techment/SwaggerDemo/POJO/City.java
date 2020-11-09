package com.techment.SwaggerDemo.POJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_city")
public class City {
	
	@Id
	@Column(name="pk_city")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="city_name")
	private String cityName;
	
	protected City() {
		
	}
	
	public City(String cityName) {
		this.cityName = cityName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	

}
