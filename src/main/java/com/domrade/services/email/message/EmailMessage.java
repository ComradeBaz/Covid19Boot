package com.domrade.services.email.message;

public class EmailMessage {

	private String from;
	private String subject;
	private String message;

	public EmailMessage() {
		// TODO Auto-generated constructor stub
	}

	public EmailMessage(String from, String subject, String message) {
		super();
		this.from = from;
		this.subject = subject;
		this.message = message;
	}

	public EmailMessage(String from, String message) {
		super();
		this.from = from;
		this.message = message;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
