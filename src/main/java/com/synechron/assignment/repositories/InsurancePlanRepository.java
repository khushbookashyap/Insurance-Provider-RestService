package com.synechron.assignment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synechron.assignment.entities.Plan;

@Repository
public interface InsurancePlanRepository extends JpaRepository<Plan, Integer> {

}
