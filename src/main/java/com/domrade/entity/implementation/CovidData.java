package com.domrade.entity.implementation;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "covid_data")
public class CovidData {

	@Id
	@Basic
	private long id;

	@Basic
	private long location;

	@Basic
	private Date date;

	@Basic
	private int data;

	@Basic
	private String type;

	public CovidData() {
		// TODO Auto-generated constructor stub
	}

}
