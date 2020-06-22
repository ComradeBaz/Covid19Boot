package com.domrade.entity.implementation;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "us_states")
public class UsStates {

	@Id
	@Basic
	private long id;

	@Basic
	private String state;

	public UsStates() {
		// TODO Auto-generated constructor stub
	}

}
