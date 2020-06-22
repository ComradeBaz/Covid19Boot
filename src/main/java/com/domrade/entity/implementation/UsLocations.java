package com.domrade.entity.implementation;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "us_locations")
public class UsLocations {

	@Id
	@Basic
	private long id;

	@Basic
	@Column(name = "state_id")
	private long stateId;

	@Basic
	private String county;

	public UsLocations() {
		// TODO Auto-generated constructor stub
	}

}
