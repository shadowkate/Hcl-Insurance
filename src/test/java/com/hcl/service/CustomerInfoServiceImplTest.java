package com.hcl.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.dto.InfoDetails;
import com.hcl.dto.InfoDto;
import com.hcl.entity.OrderDetails;
import com.hcl.repository.CustomerRepository;
import com.hcl.util.MailApi;


@RunWith(MockitoJUnitRunner.Silent.class)
public class CustomerInfoServiceImplTest {

	@Mock
	CustomerRepository customerRepository;
	@Mock
	MailApi api;

	@InjectMocks
	CustomerInfoServiceImpl customerInfoServiceImpl;

	@Test
	public void testCustInfo() {

		InfoDto infoDto = new InfoDto();
		
		infoDto.setEmail("sai@gmail.com");
		infoDto.setName("sai");
	infoDto.setSapId(12344);
	infoDto.setPolicyId(1);

		OrderDetails details = new OrderDetails();
		details.setDate(LocalDate.now());
	
		details.setEmail(infoDto.getEmail());
		details.setName(infoDto.getName());
		details.setPolicyId(infoDto.getPolicyId());
	
		int num = 100000 + new Random().nextInt(900000);
		details.setPolicyNumber(num);
		InfoDetails det = new InfoDetails();
		det.setPolicyNumber(details.getPolicyNumber());
		det.setStatusCode(200);
		det.setMessage("mail sent successfully");
		det.setStatusCode(200);
		det.setStatus("SUCCESS");

		Mockito.when(customerRepository.save(Mockito.anyObject())).thenReturn(details);

		InfoDetails det1 = customerInfoServiceImpl.custInfo(infoDto);
		Mockito.doNothing().when(api).sendMail("sai555977charan", 123456);

		assertEquals(det1.getStatus(), det.getStatus());
	}

}
