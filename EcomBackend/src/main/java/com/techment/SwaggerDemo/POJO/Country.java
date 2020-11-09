package com.techment.SwaggerDemo.POJO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="tbl_country")
public class Country {
       
    @Id
	@Column(name="pk_country")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name = "country_name")
	private String countryName;
	
    @OneToMany
    @JoinColumn(name = "fk_country")
    private List<State> states;
    
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;
	
	
   public Country() {
	
            }
	
	public Country(String countryName, List<State> states, Timestamp createdAt, Timestamp updatedAt, String createdBy,
		String updatedBy) {

	this.countryName = countryName;
	this.states = states;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
	this.createdBy = createdBy;
	this.updatedBy = updatedBy;
}
	
	

	public Country(String countryName, List<State> states, Timestamp createdAt, String createdBy) {

		this.countryName = countryName;
		this.states = states;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
