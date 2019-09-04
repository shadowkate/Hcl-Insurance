package com.hcl.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.hcl.dto.InfoDetails;
import com.hcl.dto.InfoDto;
import com.hcl.service.CustomerInfoService;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
	@InjectMocks
CustomerInfoController customerInfoController;
	@Mock
	CustomerInfoService customerInfoService;
	
	@Test
	public void testInfo() {
		InfoDto infoDto = new InfoDto();
		infoDto.setEmail("sai@gmail.com");
		infoDto.setName("sai");
	
		InfoDetails det = new InfoDetails();
		det.setStatusCode(200);
		det.setMessage("policy opted successfully");
		det.setStatusCode(200);
		det.setStatus("SUCCESS");
		
		Mockito.when(customerInfoService.custInfo(infoDto)).thenReturn(det);
		ResponseEntity entity=customerInfoController.info(infoDto);
		entity.getStatusCode();
		assertEquals(entity.getStatusCodeValue(),det.getStatusCode());
		
	}
}
