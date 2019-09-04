package com.hcl.service;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dto.InfoDetails;
import com.hcl.dto.InfoDto;
import com.hcl.entity.OrderDetails;
import com.hcl.repository.CustomerRepository;

import com.hcl.util.MailApi;

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService  {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	MailApi mailApi;

	@Override
	public InfoDetails custInfo(InfoDto infoDto) {

		OrderDetails details = new OrderDetails();
		details.setDate(LocalDate.now());
	details.setPolicyId(infoDto.getPolicyId());
		details.setEmail(infoDto.getEmail());
		details.setName(infoDto.getName());
		
		details.setSapId(infoDto.getSapId());
		details.setDependentName(infoDto.getDependentName());
		details.setPolicyFor(infoDto.getPolicyFor());
		Integer num = 100000 + new Random().nextInt(900000);
		details.setPolicyNumber(num);

		customerRepository.save(details);

	
		mailApi.sendMail(details.getEmail(), details.getPolicyNumber());
String message="Your have opted for policy with policyNumber ";
String h=num.toString();
String message1=message.concat(h);
		InfoDetails det = new InfoDetails();
	det.setPolicyNumber(details.getPolicyNumber());
		det.setMessage(message1);
		det.setStatusCode(200);
		det.setStatus("SUCCESS");
		return det;

	}

}
