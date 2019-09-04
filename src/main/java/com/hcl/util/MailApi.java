package com.hcl.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Component;



@Component
public class MailApi {
	@Autowired
	private JavaMailSender mailSender;


	public void sendMail(String mailId, Integer policyNumber) {

		String message2 = "You opted policy with policyNumber ";

		String orderGenId1 = policyNumber.toString();
		String gen3=message2.concat(orderGenId1);
String gen4="  Our HCL HR executive will get in touch with you shortly";
		String message5 = gen3.concat(gen4);

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("sai555977charan@gmail.com");
		mail.setSubject("Your Order Details");
		mail.setTo(mailId);
		mail.setText(message5);
		mail.setSubject("Your policy details");

		mailSender.send(mail);

	}
}