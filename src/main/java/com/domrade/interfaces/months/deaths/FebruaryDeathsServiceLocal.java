/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.interfaces.months.deaths;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.FebruaryDeaths;

/**
 *
 * @author David
 */
@Service
public interface FebruaryDeathsServiceLocal {

	public List<FebruaryDeaths> getAllFebruaryDeathsEntries();

	public FebruaryDeaths getFebruaryDeathsEntryByCountryRegion(String countryRegion);

	public List<String> getAllCountries();

	public List<String> getProvinceStateByCountryRegion(String countryRegion);

	public FebruaryDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState);

}
