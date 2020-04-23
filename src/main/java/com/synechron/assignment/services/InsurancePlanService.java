package com.synechron.assignment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synechron.assignment.entities.Plan;
import com.synechron.assignment.exceptions.PlanNotFoundException;
import com.synechron.assignment.repositories.InsurancePlanRepository;

@Service
public class InsurancePlanService {

	
	@Autowired
	private InsurancePlanRepository insurancePlanRepository;

	public List<Plan> findAll() {
		
		return insurancePlanRepository.findAll() ;
	}

	public Plan findById(int planId) {
		
		Optional<Plan>  result = insurancePlanRepository.findById(planId);
		Plan plan = null;
		
		if(result.isPresent()) {
			plan= result.get();
		}
		else {
			// we didn't find the employee
			throw new PlanNotFoundException("There is no plan with id = " +planId);
		}
		return plan;
	}

	public void save(Plan plan) {
		insurancePlanRepository.save(plan);
		
	}

	public void deleteById(int planId) {
		
		Plan plan = findById(planId);
		if(plan != null) {
			insurancePlanRepository.deleteById(planId);
		}
		
		
	}

	public List<Plan> findByAgeGroupAndCoverAmountAndPlanType(String ageGroup, Float coverAmount, String planType) {

		List<Plan> planList =insurancePlanRepository.findByAgeGroupAndCoverAmountAndPlanType(ageGroup,coverAmount,planType);
		
		if(planList.isEmpty()) {
			// we didn't find the employee
			throw new PlanNotFoundException("No plan found with given parameters");
		}
		return planList;
	}
	
	
}
