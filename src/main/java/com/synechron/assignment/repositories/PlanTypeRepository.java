package com.synechron.assignment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synechron.assignment.entities.PlanType;

public interface PlanTypeRepository extends JpaRepository<PlanType, Integer> {

}
