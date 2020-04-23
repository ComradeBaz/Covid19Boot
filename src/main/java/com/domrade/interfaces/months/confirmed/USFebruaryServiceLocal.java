/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.interfaces.months.confirmed;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.USFebruary;

/**
 *
 * @author David
 */
@Service
public interface USFebruaryServiceLocal {

	public List<USFebruary> getAllUSFebruaryEntries();

	public List<String> getAllUSFebruaryCountryRegionProvinceState();

	public USFebruary getUSFebruaryEntryByCountryRegion(String countryRegion);

	public List<String> getAllCountries();

	public List<String> getProvinceStateByCountryRegion(String countryRegion);

	public USFebruary findByCountryRegionProvinceState(String countryRegion, String provinceState);

	public List<USFebruary> getEntryByProvenceState(String provenceState);

}
