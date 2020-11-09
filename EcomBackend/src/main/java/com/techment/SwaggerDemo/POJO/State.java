package com.techment.SwaggerDemo.POJO;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_state")
public class State {
	
	@Id
	@Column(name="pk_state")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="state_name")
	private String stateName;
	
    @OneToMany
    @JoinColumn(name = "fk_state")
    private List<City> cities;
	
	protected State() {
		
	}
	
	

	public State(String stateName, List<City> cities) {

		this.stateName = stateName;
		this.cities = cities;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	

}
