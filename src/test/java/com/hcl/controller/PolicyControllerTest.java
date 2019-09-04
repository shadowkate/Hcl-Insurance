package com.hcl.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.dto.TrendDto;
import com.hcl.service.PolicyService;

import junit.framework.TestCase;
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = { TestCase.class, PolicyController.class })
@WebAppConfiguration
public class PolicyControllerTest {

	@InjectMocks
	private PolicyController policyController;
	

	
	@Mock
	private PolicyService policyService;
	

	private MockMvc mockMvc;
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(policyController).build();
	}
	@Test
	public void trendAnalysisTest() {
		TrendDto an=new TrendDto(1, "Insurance", 3L);
		List<TrendDto> analysis=new ArrayList<>();
		analysis.add(an);
		ResponseEntity<List<TrendDto>> expResult = new ResponseEntity<>(analysis, HttpStatus.OK);
		when(policyService.trendAnalysis()).thenReturn(analysis);
	
		ResponseEntity<List<TrendDto>> actResult = policyController.trendAnalysis();
		assertEquals(expResult, actResult);
		
	}

}