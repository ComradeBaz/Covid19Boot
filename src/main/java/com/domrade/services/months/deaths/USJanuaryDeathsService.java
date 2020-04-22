/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.months.deaths;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.dao.interfaces.USJanuaryDeathsDao;
import com.domrade.entity.implementation.USJanuaryDeaths;
import com.domrade.interfaces.months.deaths.USJanuaryDeathsServiceLocal;

/**
 *
 * @author David
 */
@Service
public class USJanuaryDeathsService implements USJanuaryDeathsServiceLocal {

	@Autowired
	private USJanuaryDeathsDao januaryDeathsDao;

	@Override
	public List<USJanuaryDeaths> getAllUSJanuaryDeathsEntries() {
		List<USJanuaryDeaths> aList = januaryDeathsDao.findAllEntries();
		return aList;
	}

	@Override
	public USJanuaryDeaths getUSJanuaryDeathsEntryByCountryRegion(String countryRegion) {
		return januaryDeathsDao.getEntryByCountryRegion(countryRegion);
	}

	@Override
	public USJanuaryDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return januaryDeathsDao.findByCountryRegionProvinceState(countryRegion, provinceState);
	}

}
