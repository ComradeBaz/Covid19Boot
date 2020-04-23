/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.months.deaths;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.dao.interfaces.USFebruaryDeathsDao;
import com.domrade.entity.implementation.USFebruaryDeaths;
import com.domrade.interfaces.months.deaths.USFebruaryDeathsServiceLocal;

/**
 *
 * @author David
 */
@Service
public class USFebruaryDeathsService implements USFebruaryDeathsServiceLocal {

	@Autowired
	private USFebruaryDeathsDao februaryDeathsDao;

	@Override
	public List<USFebruaryDeaths> getAllUSFebruaryDeathsEntries() {
		List<USFebruaryDeaths> aList = februaryDeathsDao.findAllEntries();
		return aList;
	}

	@Override
	public USFebruaryDeaths getUSFebruaryDeathsEntryByCountryRegion(String countryRegion) {
		return februaryDeathsDao.getEntryByCountryRegion(countryRegion);
	}

	@Override
	public List<String> getAllCountries() {
		return februaryDeathsDao.getAllUSFebruaryDeathsCountries();
	}

	@Override
	public List<String> getProvinceStateByCountryRegion(String countryRegion) {
		return februaryDeathsDao.getProvinceStateByCountryRegion(countryRegion);
	}

	@Override
	public USFebruaryDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return februaryDeathsDao.findByCountryRegionProvinceState(countryRegion, provinceState);
	}

	@Override
	public List<USFebruaryDeaths> getEntryByProvenceState(String provenceState) {
		return februaryDeathsDao.getEntryByProvenceState(provenceState);
	}
}
