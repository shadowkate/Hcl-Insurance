package com.hcl.service;

import java.util.List;

import com.hcl.dto.TrendDto;

public interface PolicyService {

	Object getLatestTrend(String trendRange);
	List<TrendDto> trendAnalysis();
	
}
