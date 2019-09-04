package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.entity.TermsAndConditions;

public interface TermDetailsRepository extends JpaRepository<TermsAndConditions, Integer> {

	
	public TermsAndConditions findBypolicyId(int policyId);
}
