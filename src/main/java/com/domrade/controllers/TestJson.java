/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.domrade.entity.implementation.March;
import com.domrade.interfaces.converters.ConvertToStringServiceLocal;
import com.domrade.interfaces.months.confirmed.FebruaryServiceLocal;
import com.domrade.interfaces.months.confirmed.MarchServiceLocal;

/**
 *
 * @author David
 */
@Component
@Scope("request")
public class TestJson {

	@Autowired
	private ConvertToStringServiceLocal convertToStringService;

	@Autowired
	private FebruaryServiceLocal februaryService;

	@Autowired
	private MarchServiceLocal marchService;

	private String country;

	public TestJson() {
		// no arg constructor
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String testConvertToJson() {

		March entry = marchService.getMarchEntryByCountryRegion(country);
		convertToStringService.convertGenericObjectToJsonArray(entry);

		return convertToStringService.convertGenericObjectToJsonArray(entry);
	}
}
