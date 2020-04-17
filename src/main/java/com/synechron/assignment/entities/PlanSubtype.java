package com.synechron.assignment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "planSubtype")
public class PlanSubtype {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "plan_subtype")
	private String planSubtype;

	// default constructor
	public PlanSubtype() {

	}

	// parameterized constructor
	public PlanSubtype(String planSubtype) {
		super();
		this.planSubtype = planSubtype;
	}

	@Override
	public String toString() {
		return "PlanSubtype [id=" + id + ", planSubtype=" + planSubtype + "]";
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlanSubtype() {
		return planSubtype;
	}

	public void setPlanSubtype(String planSubtype) {
		this.planSubtype = planSubtype;
	}

}
