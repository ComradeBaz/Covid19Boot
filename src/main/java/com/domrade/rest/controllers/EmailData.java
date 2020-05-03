package com.domrade.rest.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.domrade.interfaces.converters.ConvertToStringServiceLocal;
import com.domrade.interfaces.email.SendEmailServiceLocal;
import com.domrade.services.email.message.EmailMessage;
import com.domrade.services.email.message.EmailResponse;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class EmailData {

	@Autowired
	private SendEmailServiceLocal sendEmailService;

	@Autowired
	private ConvertToStringServiceLocal convertToStringService;

	@PostMapping("/sendEmail")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getProvinceStateByCountry(@RequestBody EmailMessage sendMessage) {

		String from = sendMessage.getFrom();
		String message = sendMessage.getMessage();

		sendEmailService.sendEmail(from, message);

		return convertToStringService.convertGenericObjectToJsonObject(new EmailResponse("Message Sent"));
	}

}
