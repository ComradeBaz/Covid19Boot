/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.interfaces.months.confirmed;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.February;

/**
 *
 * @author David
 */
@Service
public interface FebruaryServiceLocal {

	public List<February> getAllFebruaryEntries();

	public List<String> getAllFebruaryCountryRegionProvinceState();

	public February getFebruaryEntryByCountryRegion(String countryRegion);

	public List<String> getAllCountries();

	public List<String> getProvinceStateByCountryRegion(String countryRegion);

	public February findByCountryRegionProvinceState(String countryRegion, String provinceState);

}
