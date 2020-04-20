/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.interfaces.months.deaths;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.JanuaryDeaths;

/**
 *
 * @author David
 */
@Service
public interface JanuaryDeathsServiceLocal {

	public List<JanuaryDeaths> getAllJanuaryDeathsEntries();

	public JanuaryDeaths getJanuaryDeathsEntryByCountryRegion(String countryRegion);

	public JanuaryDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState);

}
