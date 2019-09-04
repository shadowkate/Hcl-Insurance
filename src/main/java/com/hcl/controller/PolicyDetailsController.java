package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.PolicyDescriptionResponseDto;
import com.hcl.dto.PolicyNamesDto;
import com.hcl.service.PolicyDetailsService;

@RequestMapping("/api")
@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class PolicyDetailsController {

	@Autowired
	PolicyDetailsService policyService;
	
	@GetMapping("/policies")
	public ResponseEntity<PolicyNamesDto> getPolicyNames()
	{
		return new ResponseEntity(policyService.getPolicyNames(),HttpStatus.OK);
	}
	
	@GetMapping("/policies/{policyId}")
	public ResponseEntity<PolicyDescriptionResponseDto> getPolicyDescription(@PathVariable("policyId") int policyId)
	{
		return new ResponseEntity(policyService.getPolicyDescription(policyId),HttpStatus.OK);
	}
	
}
