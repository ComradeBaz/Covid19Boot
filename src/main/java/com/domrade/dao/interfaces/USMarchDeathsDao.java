/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.USMarchDeaths;

/**
 *
 * @author David
 */
@Service
public interface USMarchDeathsDao extends Dao<Long, USMarchDeaths> {

	public List<USMarchDeaths> findAllEntries();

	public USMarchDeaths getEntryByCountryRegion(String countryRegion);

	public USMarchDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState);

	public List<USMarchDeaths> getEntryByProvenceState(String provenceState);

}
