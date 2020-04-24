package com.domrade.rest.request;

public class UsStateAndCounty {

	private String state;
	private String county;

	public UsStateAndCounty() {
		// TODO Auto-generated constructor stub
	}

	public UsStateAndCounty(String state, String county) {
		super();
		this.state = state;
		this.county = county;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

}
