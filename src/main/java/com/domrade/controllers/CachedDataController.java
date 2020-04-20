/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.domrade.interfaces.local.CachedDataLocal;

/**
 *
 * @author David
 */
@Component
@Scope("request")
public class CachedDataController {

	@Autowired
	private CachedDataLocal cachedData;

	private List<String> allCountries;

	public void CachedData() {
		// no arg constructor
	}

	@PostConstruct
	public void init() {
		setAllCountries(cachedData.getAllCountries());
	}

	public List<String> getAllCountries() {
		return allCountries;
	}

	public void setAllCountries(List<String> allCountries) {
		this.allCountries = allCountries;
	}

}
