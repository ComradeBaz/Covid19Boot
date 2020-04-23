/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.months.deaths;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.dao.interfaces.USMarchDeathsDao;
import com.domrade.entity.implementation.USMarchDeaths;
import com.domrade.interfaces.months.deaths.USMarchDeathsServiceLocal;

/**
 *
 * @author David
 */
@Service
public class USMarchDeathsService implements USMarchDeathsServiceLocal {

	@Autowired
	private USMarchDeathsDao marchDeathsDao;

	@Override
	public List<USMarchDeaths> getAllUSMarchDeathsEntries() {
		List<USMarchDeaths> aList = marchDeathsDao.findAllEntries();
		return aList;
	}

	@Override
	public USMarchDeaths getUSMarchDeathsEntryByCountryRegion(String countryRegion) {
		return marchDeathsDao.getEntryByCountryRegion(countryRegion);
	}

	@Override
	public USMarchDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return marchDeathsDao.findByCountryRegionProvinceState(countryRegion, provinceState);
	}

	@Override
	public List<USMarchDeaths> getEntryByProvenceState(String provenceState) {
		return marchDeathsDao.getEntryByProvenceState(provenceState);
	}

}
