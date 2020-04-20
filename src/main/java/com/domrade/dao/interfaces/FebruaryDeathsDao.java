/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.FebruaryDeaths;

/**
 *
 * @author David
 */
@Service
public interface FebruaryDeathsDao extends Dao<Long, FebruaryDeaths> {

	public List<FebruaryDeaths> findAllEntries();

	public FebruaryDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState);

	public FebruaryDeaths getEntryByCountryRegion(String countryRegion);

	public List<String> getAllFebruaryDeathsCountries();

	public List<String> getProvinceStateByCountryRegion(String countryRegion);;
}
