package com.hcl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dto.PolicyDescriptionResponseDto;
import com.hcl.dto.PolicyIdDto;
import com.hcl.dto.PolicyNamesDto;
import com.hcl.dto.TermsDescription;
import com.hcl.entity.Policy;
import com.hcl.entity.TermsAndConditions;
import com.hcl.exception.PolicyException;
import com.hcl.repository.PolicyRepository;
import com.hcl.repository.TermDetailsRepository;

@Service
public class PolicyDetailsServiceImpl implements PolicyDetailsService {

	@Autowired
	PolicyRepository policyRepository;
	
	@Autowired
	TermDetailsRepository termsRepository;
	
	public PolicyNamesDto getPolicyNames() {
		
		PolicyNamesDto policyNames = new PolicyNamesDto();
		
		List<Policy> policyData = policyRepository.findAll();
		List<PolicyIdDto> policyIdList = new ArrayList<>();
		
		for(int i =0;i<policyData.size();i++)
		{
			PolicyIdDto policyId = new PolicyIdDto();
			policyId.setPolicyId(policyData.get(i).getPolicyId());
			policyId.setPolicyName(policyData.get(i).getPolicyName());
			policyId.setPolicyPrice(policyData.get(i).getPolicyPrice());
			policyId.setSumAssured(policyData.get(i).getSumAssured());
			policyIdList.add(policyId);
		}
		
		if(!policyIdList.isEmpty())
		{		
			policyNames.setData(policyIdList);
			policyNames.setMessage("list of id with names");
			policyNames.setStatus("SUCCESS");
			policyNames.setStatusCode(200);
			policyNames.setMessage("Policy List with data is showing");
			return policyNames;
		}else
		{
			throw new PolicyException("Policy Names are not available");
		}
		
		
		//return policyNames;
	}

	
	public PolicyDescriptionResponseDto getPolicyDescription(int policyId) {
		PolicyDescriptionResponseDto policyResponse = new PolicyDescriptionResponseDto();
		TermsDescription termsDto = new TermsDescription();
		
		Optional<Policy> policy = policyRepository.findById(policyId);
		if(policy.isPresent())
		{
			policyResponse.setFeatures(policy.get().getFeatures());
			policyResponse.setBenefits(policy.get().getPolicyBenifits());
			policyResponse.setPolicyDescription(policy.get().getPolicyDescription());
			policyResponse.setPolicyId(policy.get().getPolicyId());
			policyResponse.setPolicyName(policy.get().getPolicyName());
			policyResponse.setPolicyPrice(policy.get().getPolicyPrice());
			policyResponse.setSumAssured(policy.get().getSumAssured());
		}
		
		List<TermsDescription> termsList = new ArrayList<>();
		
		TermsAndConditions terms = termsRepository.findBypolicyId(policyId);
		termsDto.setEntryLimit(terms.getEntryLimit());
		termsDto.setTaxBenefit(terms.getTaxBenifit());
		termsList.add(termsDto);
		
		policyResponse.setTaxBenefit(terms.getTaxBenifit());
		policyResponse.setEntryLimit(terms.getEntryLimit());
		
		policyResponse.setStatus("SUCCESS");
		policyResponse.setStatusCode(200);
		policyResponse.setMessage("Policy Description is showing");
		
		policyResponse.setTerms(termsList);
		
		return policyResponse;
	}

}
