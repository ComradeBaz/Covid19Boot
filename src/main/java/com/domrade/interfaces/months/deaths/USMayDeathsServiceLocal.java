/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.interfaces.months.deaths;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.USMayDeaths;

/**
 *
 * @author David
 */
@Service
public interface USMayDeathsServiceLocal {

	public List<USMayDeaths> getAllUSMayDeathsEntries();

	public USMayDeaths getUSMayDeathsEntryByCountryRegion(String countryRegion);

	public USMayDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState);

	public List<USMayDeaths> getEntryByProvenceState(String provenceState);
}
