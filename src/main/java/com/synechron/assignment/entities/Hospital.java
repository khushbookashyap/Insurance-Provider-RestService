package com.synechron.assignment.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="hospital")
@JsonIgnoreProperties({ "plans"})
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String hospitalName;
	private String city;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "plan_hospital", joinColumns = { @JoinColumn(name = "hospital_id") }, inverseJoinColumns = {
			@JoinColumn(name = "plan_id") })
	private List<Plan> plans;
	
	//default constructor
	public Hospital() {
		
	}

	//constructor using fields
	public Hospital(String hospitalName, String city, List<Plan> plans) {
		super();
		this.hospitalName = hospitalName;
		this.city = city;
		this.plans = plans;
	}
	

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", hospitalName=" + hospitalName + ", city=" + city + "]";
	}

	
	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Plan> getPlans() {
		return plans;
	}

	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}
	
	
	
	
}
