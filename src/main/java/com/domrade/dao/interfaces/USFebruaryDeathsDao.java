/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.USFebruaryDeaths;

/**
 *
 * @author David
 */
@Service
public interface USFebruaryDeathsDao extends Dao<Long, USFebruaryDeaths> {

	public List<USFebruaryDeaths> findAllEntries();

	public USFebruaryDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState);

	public USFebruaryDeaths getEntryByCountryRegion(String countryRegion);

	public List<String> getAllUSFebruaryDeathsCountries();

	public List<String> getProvinceStateByCountryRegion(String countryRegion);;
}
