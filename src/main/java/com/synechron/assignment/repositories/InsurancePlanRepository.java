package com.synechron.assignment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.synechron.assignment.entities.Plan;

@Repository
public interface InsurancePlanRepository extends JpaRepository<Plan, Integer> {

	@Query("select p from Plan p , PlanType pt where p.ageGroup=:ageGroup and p.coverAmount=:coverAmount and pt.planType=:planType")
	List<Plan> findByAgeGroupAndCoverAmountAndPlanType(@Param("ageGroup")String ageGroup, @Param("coverAmount")Float coverAmount, @Param("planType")String planType);

}
