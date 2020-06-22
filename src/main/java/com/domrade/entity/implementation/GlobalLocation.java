package com.domrade.entity.implementation;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "global_locations")
public class GlobalLocation {

	@Id
	@Basic
	private long id;

	@Basic
	private String location;

	public GlobalLocation() {
		// TODO Auto-generated constructor stub
	}

}
