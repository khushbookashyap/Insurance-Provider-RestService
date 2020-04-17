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
	private int id;

	private String planName;
	private String cityTier;
	private long coverAmount;
	private long premiumAmount;
	private String premiumPeriod;
	private int claimSettlementRatio;
	private String features;

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

	// parameterized constructor
	public Plan(String planName, String cityTier, long coverAmount, long premiumAmount, String premiumPeriod,
			int claimSettlementRatio, String features, PlanType planType, PlanSubtype planSubtype,
			List<Hospital> hospitals) {
		super();
		this.planName = planName;
		this.cityTier = cityTier;
		this.coverAmount = coverAmount;
		this.premiumAmount = premiumAmount;
		this.premiumPeriod = premiumPeriod;
		this.claimSettlementRatio = claimSettlementRatio;
		this.features = features;
		this.planType = planType;
		this.planSubtype = planSubtype;
		this.hospitals = hospitals;
	}

	@Override
	public String toString() {
		return "Plan [id=" + id + ", planName=" + planName + ", cityTier=" + cityTier + ", coverAmount=" + coverAmount
				+ ", premiumAmount=" + premiumAmount + ", premiumPeriod=" + premiumPeriod + ", claimSettlementRatio="
				+ claimSettlementRatio + ", features=" + features + ", planType=" + planType + ", planSubtype="
				+ planSubtype + ", hospitals=" + hospitals + "]";
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public long getCoverAmount() {
		return coverAmount;
	}

	public void setCoverAmount(long coverAmount) {
		this.coverAmount = coverAmount;
	}

	public long getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(long premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public String getPremiumPeriod() {
		return premiumPeriod;
	}

	public void setPremiumPeriod(String premiumPeriod) {
		this.premiumPeriod = premiumPeriod;
	}

	public int getClaimSettlementRatio() {
		return claimSettlementRatio;
	}

	public void setClaimSettlementRatio(int claimSettlementRatio) {
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

}
