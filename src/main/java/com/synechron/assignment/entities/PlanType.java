package com.synechron.assignment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="planType")
public class PlanType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="plan_type")
	private String planType;

	//default Constructor
	public PlanType() {
		
	}
	
	//parameterized constructor
	public PlanType(String planType) {
		super();
		this.planType = planType;
	}

	@Override
	public String toString() {
		return "PlanType [id=" + id + ", planType=" + planType + "]";
	}

	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	
}
