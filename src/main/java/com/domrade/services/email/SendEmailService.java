package com.domrade.services.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.domrade.interfaces.email.SendEmailServiceLocal;

@Service
public class SendEmailService implements SendEmailServiceLocal {

	@Autowired
	private JavaMailSender javaMailSender;

	public SendEmailService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sendEmail(String from, String message) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("myc0vid19charts@gmail.com");
		msg.setFrom(from);
		msg.setSubject("New Message");
		msg.setText(message + System.getProperty("line.separator") + from);

		javaMailSender.send(msg);
	}

}
