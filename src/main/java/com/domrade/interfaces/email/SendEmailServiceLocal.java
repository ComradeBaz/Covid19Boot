package com.domrade.interfaces.email;

import org.springframework.stereotype.Service;

@Service
public interface SendEmailServiceLocal {

	public void sendEmail(String from, String message);
}
