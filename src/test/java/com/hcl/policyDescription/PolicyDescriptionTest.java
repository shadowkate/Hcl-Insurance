package com.hcl.policyDescription;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.dto.PolicyIdDto;
import com.hcl.dto.PolicyNamesDto;
import com.hcl.entity.Policy;
import com.hcl.exception.PolicyException;
import com.hcl.repository.PolicyRepository;
import com.hcl.repository.TermDetailsRepository;
import com.hcl.service.PolicyDetailsServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PolicyDescriptionTest {
	
	@InjectMocks
	PolicyDetailsServiceImpl policyService;
	
	@Mock
	PolicyRepository policyRepository;
	
	@Mock
	TermDetailsRepository termRepository;
	
	public Policy getPolicy1()
	{
		Policy policy = new Policy();
		policy.setPolicyName("Test1");
		policy.setPolicyId(1);
		return policy;
	}
	
	public Policy getPolicy2()
	{
		Policy policy = new Policy();
		policy.setPolicyName("Test1");
		policy.setPolicyId(1);
		return policy;
	}
	
	public PolicyIdDto policyIdDto()
	{
		PolicyIdDto policy = new PolicyIdDto();
		policy.setPolicyId(1);
		policy.setPolicyName("Test1");
		return policy;
	}
	
	public PolicyIdDto policyIdDto1()
	{
		PolicyIdDto policy = new PolicyIdDto();
		policy.setPolicyId(2);
		policy.setPolicyName("Test1");
		return policy;
	}
	
	public PolicyNamesDto getPolicyNamesDto()
	{
		List<PolicyIdDto> policyList = new ArrayList<PolicyIdDto>();
		policyList.add(policyIdDto());
		policyList.add(policyIdDto1());
		PolicyNamesDto policyNames = new PolicyNamesDto();
		policyNames.setData(policyList);
		policyNames.setMessage("list of id with names");
		policyNames.setStatus("SUCCESS");
		policyNames.setStatusCode(200);
		return policyNames;
	}
	
	
	@Test
	public void policyNamePositive()
	{
		List<Policy> policyList = new ArrayList<Policy>();
		policyList.add(getPolicy1());
		policyList.add(getPolicy2());
		Mockito.when(policyRepository.findAll()).thenReturn(policyList);
		PolicyNamesDto policyNames = policyService.getPolicyNames();
		Assert.assertEquals("SUCCESS", policyNames.getStatus());
	}
	
	@Test(expected = PolicyException.class)
	public void PolicyNameNegative()
	{
		List<Policy> policyList = new ArrayList<Policy>();
		Mockito.when(policyRepository.findAll()).thenReturn(policyList);
		PolicyNamesDto policyNames = policyService.getPolicyNames();
		Assert.assertEquals("SUCCESS", policyNames.getStatus());
	}

}
