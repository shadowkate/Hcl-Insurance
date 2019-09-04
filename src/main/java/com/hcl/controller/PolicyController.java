package com.hcl.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.TrendDto;
import com.hcl.service.PolicyService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class PolicyController {
	private static final Logger logger = LoggerFactory.getLogger(PolicyController.class);
	@Autowired
	private PolicyService policyService;

	@GetMapping("/latesttrends/{trendRange}")
	public ResponseEntity<Object> getLatestTrend(@PathVariable String trendRange) {
		logger.debug("PolicyController trendAnalysis()");
		return new ResponseEntity<>(policyService.getLatestTrend(trendRange), HttpStatus.OK);
	}

	@GetMapping("/trends")
	public ResponseEntity<List<TrendDto>> trendAnalysis() {
		logger.debug("PolicyController trendAnalysis()");
		return new ResponseEntity<>(policyService.trendAnalysis(), HttpStatus.OK);
	}
}
