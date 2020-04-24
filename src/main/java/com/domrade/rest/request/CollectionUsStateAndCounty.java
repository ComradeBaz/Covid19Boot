package com.domrade.rest.request;

public class CollectionUsStateAndCounty {

	private UsStateAndCounty statesAndCounties[];
	private String requestType;
	private String entityType;
	private String level;

	public CollectionUsStateAndCounty() {
		// TODO Auto-generated constructor stub
	}

	public CollectionUsStateAndCounty(UsStateAndCounty[] statesAndCounties, String requestType, String entityType,
			String level) {
		super();
		this.statesAndCounties = statesAndCounties;
		this.requestType = requestType;
		this.entityType = entityType;
		this.level = level;
	}

	public UsStateAndCounty[] getStatesAndCounties() {
		return statesAndCounties;
	}

	public void setStatesAndCounties(UsStateAndCounty[] statesAndCounties) {
		this.statesAndCounties = statesAndCounties;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
