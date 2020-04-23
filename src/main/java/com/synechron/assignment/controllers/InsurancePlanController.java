package com.synechron.assignment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synechron.assignment.entities.Plan;
import com.synechron.assignment.services.InsurancePlanService;

@RestController
@RequestMapping("/api/v1")
public class InsurancePlanController {

	
	@Autowired
	private InsurancePlanService insurancePlanService;
	
	@GetMapping("/plans")
	public List<Plan> getAllPlans(){
		
		return insurancePlanService.findAll();
	}
	
	@GetMapping("/plans/{planId}")
	public Plan viewPlan(@PathVariable int planId) {
		 
		Plan plan = insurancePlanService.findById(planId);
		return plan;
	}
	
	@GetMapping("/plans/{ageGroup}/{coverAmount}/{planType}")
	public List<Plan> viewPlanByAgeAndCoverAndType(@PathVariable String ageGroup, @PathVariable Float coverAmount,@PathVariable String planType) {
		 System.out.println("this is our function");
		List<Plan> resultList = insurancePlanService.findByAgeGroupAndCoverAmountAndPlanType(ageGroup,coverAmount,planType);
		return resultList;
	}
	
	@PostMapping("/plans")
	public void addPlan(@RequestBody Plan plan) {
		
		//in case someone sends the id also through json data
		if(plan.getId() != null) {
			throw new IllegalArgumentException("Id can not be passed while adding new plans");
		}
		insurancePlanService.save(plan);
	}
	
	@PutMapping("/plans")
	public Plan updatePlan(@RequestBody Plan plan) {
		insurancePlanService.save(plan);
		return plan;
	}
	
	@DeleteMapping("/plans/{planId}")
	public int deletePlan(@PathVariable int planId) {
		insurancePlanService.deleteById(planId);
		return planId;
	}
	
}
