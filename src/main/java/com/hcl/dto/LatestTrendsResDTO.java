package com.hcl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LatestTrendsResDTO {
	private Integer policyId;
	private String policyName;
	private Double policyPrice;
	private Double sumAssured;
	private Double percentage;
}
