package com.hcl.policyDescription;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.dto.PolicyDescriptionResponseDto;
import com.hcl.dto.PolicyNamesDto;
import com.hcl.entity.Policy;
import com.hcl.entity.TermsAndConditions;
import com.hcl.repository.PolicyRepository;
import com.hcl.repository.TermDetailsRepository;
import com.hcl.service.PolicyDetailsServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PolicyNameTest {

	
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
	
	public PolicyDescriptionResponseDto getPolicyDescriptionResponseDto()
	{
		PolicyDescriptionResponseDto policy = new PolicyDescriptionResponseDto();
		policy.setBenefits("test for that");
		policy.setEntryLimit("18 - 25 years");
		policy.setStatus("SUCCESS");
		return policy;
	}
	
	public TermsAndConditions getTerms()
	{
		TermsAndConditions terms = new TermsAndConditions();
		terms.setEntryLimit("18-35 years");
		terms.setPolicyId(1);
		terms.setPolicyTerm("term to be added");
		return terms;
	}
	
	@Test
	public void TestPolicyDescription()
	{
		Mockito.when(policyRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(getPolicy1()));
		Mockito.when(termRepository.findBypolicyId(Mockito.anyInt())).thenReturn(getTerms());
		PolicyDescriptionResponseDto policyNames = policyService.getPolicyDescription(Mockito.anyInt());
		Assert.assertEquals("SUCCESS", policyNames.getStatus());
	}
	
}
