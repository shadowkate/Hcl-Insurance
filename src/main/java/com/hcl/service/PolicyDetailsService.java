package com.hcl.service;


import org.springframework.stereotype.Service;

import com.hcl.dto.PolicyDescriptionResponseDto;
import com.hcl.dto.PolicyNamesDto;

@Service
public interface PolicyDetailsService {

	public PolicyNamesDto getPolicyNames();
	
	public PolicyDescriptionResponseDto getPolicyDescription(int policyId);
}
