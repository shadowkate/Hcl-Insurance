package com.hcl.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PolicyNamesDto {

	private String message; 
	private int statusCode;
	private String status;
	private List<PolicyIdDto> data;
	
}
