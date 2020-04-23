/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.interfaces.months.confirmed;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.USJanuary;

/**
 *
 * @author David
 */
@Service
public interface USJanuaryServiceLocal {

	public List<USJanuary> getAllUSJanuaryEntries();

	public USJanuary getUSJanuaryEntryByCountryRegion(String countryRegion);

	public USJanuary findByCountryRegionProvinceState(String countryRegion, String provinceState);

	public List<String> getAllStates();

	public List<USJanuary> getEntryByProvenceState(String provenceState);

}
