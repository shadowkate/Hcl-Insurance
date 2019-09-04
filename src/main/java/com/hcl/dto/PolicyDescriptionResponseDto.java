package com.hcl.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PolicyDescriptionResponseDto {

	
	private String message; 
	private int statusCode;
	private String status;
	private int policyId;
	private String policyName;
	private String policyDescription;
	private String policyType;
	private Double policyPrice;
	private String policyTerm;
	private String benefits;
	private String features;
	private Double sumAssured;
	private String taxBenefit;
	private String entryLimit;
	private List<TermsDescription> terms;
}
