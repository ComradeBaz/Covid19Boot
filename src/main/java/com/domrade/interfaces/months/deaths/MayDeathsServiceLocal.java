/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.interfaces.months.deaths;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.MayDeaths;

/**
 *
 * @author David
 */
@Service
public interface MayDeathsServiceLocal {

	public List<MayDeaths> getAllMayDeathsEntries();

	public MayDeaths getMayDeathsEntryByCountryRegion(String countryRegion);

	public MayDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState);
}
