package com.hcl.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.dto.TrendDto;
import com.hcl.repository.OrderDetailsRepository;


@RunWith(MockitoJUnitRunner.class)
public class PolicyServiceImplTest {

	@Mock
	private OrderDetailsRepository orderRepository;
	
	@InjectMocks
	private PolicyServiceImpl policyService;
	
	@Test
	public void trendAnalysistest() {
		TrendDto td=new TrendDto(1, "Insurance", 3L);
		List<TrendDto> expResult=new ArrayList<>();
		expResult.add(td);
		Mockito.when(orderRepository.findAnalysis()).thenReturn(expResult);
		List<TrendDto> actResult=policyService.trendAnalysis();
		assertEquals(expResult, actResult);
	}

}