package com.nit.saif.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nit.saif.entity.EligibilityDetails;

public interface IEligibilityRepository extends JpaRepository<EligibilityDetails, Integer> {
	@Query("select distinct(planName) from EligibilityDetails")
	public List<String> getUniquePlanName();
	
	@Query("select distinct(planStatus) from EligibilityDetails")
	public List<String> getUniquePlanStatus();
}
