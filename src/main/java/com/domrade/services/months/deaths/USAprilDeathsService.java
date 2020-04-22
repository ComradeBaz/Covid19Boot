/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.months.deaths;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.dao.interfaces.USAprilDeathsDao;
import com.domrade.entity.implementation.USAprilDeaths;
import com.domrade.interfaces.months.deaths.USAprilDeathsServiceLocal;

/**
 *
 * @author David
 */
@Service
public class USAprilDeathsService implements USAprilDeathsServiceLocal {

	@Autowired
	private USAprilDeathsDao aprilDeathsDao;

	@Override
	public List<USAprilDeaths> getAllUSAprilDeathsEntries() {
		List<USAprilDeaths> aList = aprilDeathsDao.findAllEntries();
		for (USAprilDeaths a : aList) {
		}
		return aList;
	}

	@Override
	public USAprilDeaths getUSAprilDeathsEntryByCountryRegion(String countryRegion) {
		return aprilDeathsDao.getEntryByCountryRegion(countryRegion);
	}

	@Override
	public USAprilDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return aprilDeathsDao.findByCountryRegionProvinceState(countryRegion, provinceState);
	}

}
