package com.synechron.assignment.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "plans")
public class Plan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String planName;
	private String cityTier;
	private Float coverAmount;
	private Float premiumAmount;
	private String premiumPeriod;
	private Integer claimSettlementRatio;
	private String features;
	private String ageGroup;

	
	@OneToOne
	@JoinColumn(name = "planTypeId")
	private PlanType planType;

	@OneToOne
	@JoinColumn(name = "planSubtypeId")
	private PlanSubtype planSubtype;

	@ManyToMany(fetch = FetchType.LAZY) // cascade not required
	@JoinTable(name = "plan_hospital", joinColumns = { @JoinColumn(name = "plan_id") }, inverseJoinColumns = {
			@JoinColumn(name = "hospital_id") })
	private List<Hospital> hospitals;

	// default constructors
	public Plan() {

	}

	@Override
	public String toString() {
		return "Plan [id=" + id + ", planName=" + planName + ", cityTier=" + cityTier + ", coverAmount=" + coverAmount
				+ ", premiumAmount=" + premiumAmount + ", premiumPeriod=" + premiumPeriod + ", claimSettlementRatio="
				+ claimSettlementRatio + ", features=" + features + ", ageRange=" + ageGroup + ", planType=" + planType
				+ ", planSubtype=" + planSubtype + ", hospitals=" + hospitals + "]";
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getCityTier() {
		return cityTier;
	}

	public void setCityTier(String cityTier) {
		this.cityTier = cityTier;
	}

	public Float getCoverAmount() {
		return coverAmount;
	}

	public void setCoverAmount(Float coverAmount) {
		this.coverAmount = coverAmount;
	}

	public Float getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(Float premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public String getPremiumPeriod() {
		return premiumPeriod;
	}

	public void setPremiumPeriod(String premiumPeriod) {
		this.premiumPeriod = premiumPeriod;
	}

	public Integer getClaimSettlementRatio() {
		return claimSettlementRatio;
	}

	public void setClaimSettlementRatio(Integer claimSettlementRatio) {
		this.claimSettlementRatio = claimSettlementRatio;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public PlanType getPlanType() {
		return planType;
	}

	public void setPlanType(PlanType planType) {
		this.planType = planType;
	}

	public PlanSubtype getPlanSubtype() {
		return planSubtype;
	}

	public void setPlanSubtype(PlanSubtype planSubtype) {
		this.planSubtype = planSubtype;
	}

	public List<Hospital> getHospitals() {
		return hospitals;
	}

	public void setHospitals(List<Hospital> hospitals) {
		this.hospitals = hospitals;
	}
	
	public String getAgeRange() {
		return ageGroup;
	}

	public void setAgeRange(String ageRange) {
		this.ageGroup = ageRange;
	}


}
