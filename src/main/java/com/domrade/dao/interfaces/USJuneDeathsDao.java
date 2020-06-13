/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.USJuneDeaths;

/**
 *
 * @author David
 */
@Service
public interface USJuneDeathsDao extends Dao<Long, USJuneDeaths> {

	public List<USJuneDeaths> findAllEntries();

	public USJuneDeaths getEntryByCountryRegion(String countryRegion);

	public USJuneDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState);

	public List<USJuneDeaths> getEntryByProvenceState(String provenceState);

}
