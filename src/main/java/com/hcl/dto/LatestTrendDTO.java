package com.hcl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class LatestTrendDTO {
	private Integer policyId;
	private String policyName;
	private Double policyPrice;
	private Double sumAssured;
}
