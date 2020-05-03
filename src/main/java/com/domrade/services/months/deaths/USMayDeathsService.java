/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.months.deaths;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.dao.interfaces.USMayDeathsDao;
import com.domrade.entity.implementation.USMayDeaths;
import com.domrade.interfaces.months.deaths.USMayDeathsServiceLocal;

/**
 *
 * @author David
 */
@Service
public class USMayDeathsService implements USMayDeathsServiceLocal {

	@Autowired
	private USMayDeathsDao mayDeathsDao;

	@Override
	public List<USMayDeaths> getAllUSMayDeathsEntries() {
		List<USMayDeaths> aList = mayDeathsDao.findAllEntries();
		return aList;
	}

	@Override
	public USMayDeaths getUSMayDeathsEntryByCountryRegion(String countryRegion) {
		return mayDeathsDao.getEntryByCountryRegion(countryRegion);
	}

	@Override
	public USMayDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return mayDeathsDao.findByCountryRegionProvinceState(countryRegion, provinceState);
	}

	@Override
	public List<USMayDeaths> getEntryByProvenceState(String provenceState) {
		return mayDeathsDao.getEntryByProvenceState(provenceState);
	}

}
