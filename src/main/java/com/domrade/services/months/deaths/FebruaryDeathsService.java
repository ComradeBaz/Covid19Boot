/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.months.deaths;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.dao.interfaces.FebruaryDeathsDao;
import com.domrade.entity.implementation.FebruaryDeaths;
import com.domrade.interfaces.months.deaths.FebruaryDeathsServiceLocal;

/**
 *
 * @author David
 */
@Service
public class FebruaryDeathsService implements FebruaryDeathsServiceLocal {

	@Autowired
	private FebruaryDeathsDao februaryDeathsDao;

	@Override
	public List<FebruaryDeaths> getAllFebruaryDeathsEntries() {
		List<FebruaryDeaths> aList = februaryDeathsDao.findAllEntries();
		return aList;
	}

	@Override
	public FebruaryDeaths getFebruaryDeathsEntryByCountryRegion(String countryRegion) {
		return februaryDeathsDao.getEntryByCountryRegion(countryRegion);
	}

	@Override
	public List<String> getAllCountries() {
		return februaryDeathsDao.getAllFebruaryDeathsCountries();
	}

	@Override
	public List<String> getProvinceStateByCountryRegion(String countryRegion) {
		return februaryDeathsDao.getProvinceStateByCountryRegion(countryRegion);
	}

	@Override
	public FebruaryDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return februaryDeathsDao.findByCountryRegionProvinceState(countryRegion, provinceState);
	}
}
