/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.USMayDeaths;

/**
 *
 * @author David
 */
@Service
public interface USMayDeathsDao extends Dao<Long, USMayDeaths> {

	public List<USMayDeaths> findAllEntries();

	public USMayDeaths getEntryByCountryRegion(String countryRegion);

	public USMayDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState);

	public List<USMayDeaths> getEntryByProvenceState(String provenceState);

}
