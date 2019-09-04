package com.hcl.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

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
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.dto.PolicyDescriptionResponseDto;
import com.hcl.dto.PolicyNamesDto;
import com.hcl.service.PolicyDetailsService;


@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class PolicyNameControllerTest {
	
	
	private MockMvc mockMvc;
	
	@Mock
	PolicyDetailsService policyService;
	
	@InjectMocks
	PolicyDetailsController policyController;
	
	
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(policyController).build();
    }
	
	public PolicyNamesDto getPolicyNamesDto()
	{
		PolicyNamesDto policy = new PolicyNamesDto();
		policy.setStatus("SUCCESS");
		policy.setStatusCode(200);
		policy.setMessage("Policy List with data is showing");
		return policy;
	}
	
	public PolicyDescriptionResponseDto getPolicyDescriptionResponseDto()
	{
		PolicyDescriptionResponseDto policy = new PolicyDescriptionResponseDto();
		policy.setBenefits("test for that");
		policy.setEntryLimit("18 - 25 years");
		policy.setStatus("SUCCESS");
		return policy;
	}
	
	
	@Test
	public void productNamesTest() throws Exception
	{
		ResponseEntity<PolicyNamesDto> expResult = new ResponseEntity<>(getPolicyNamesDto(), HttpStatus.OK);
        when(policyService.getPolicyNames()).thenReturn(getPolicyNamesDto());
        ResponseEntity<PolicyNamesDto> actResult =policyController.getPolicyNames();
        assertEquals(expResult.getStatusCode(), actResult.getStatusCode());
	}
	
	
	@Test
	public void productDescriptionTest() throws Exception
	{
		ResponseEntity<PolicyDescriptionResponseDto> expResult = new ResponseEntity<>(getPolicyDescriptionResponseDto(), HttpStatus.OK);
        when(policyService.getPolicyDescription(Mockito.anyInt())).thenReturn(getPolicyDescriptionResponseDto());
        ResponseEntity<PolicyDescriptionResponseDto> actResult = policyController.getPolicyDescription(Mockito.anyInt());
        assertEquals(expResult.getStatusCode(), actResult.getStatusCode());
	}

}
