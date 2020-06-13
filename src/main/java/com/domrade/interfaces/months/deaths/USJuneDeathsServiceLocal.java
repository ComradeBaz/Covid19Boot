/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.interfaces.months.deaths;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.USJuneDeaths;

/**
 *
 * @author David
 */
@Service
public interface USJuneDeathsServiceLocal {

	public List<USJuneDeaths> getAllUSJuneDeathsEntries();

	public USJuneDeaths getUSJuneDeathsEntryByCountryRegion(String countryRegion);

	public USJuneDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState);

	public List<USJuneDeaths> getEntryByProvenceState(String provenceState);
}
