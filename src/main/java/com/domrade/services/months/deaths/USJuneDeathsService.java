/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.months.deaths;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.dao.interfaces.USJuneDeathsDao;
import com.domrade.entity.implementation.USJuneDeaths;
import com.domrade.interfaces.months.deaths.USJuneDeathsServiceLocal;

/**
 *
 * @author David
 */
@Service
public class USJuneDeathsService implements USJuneDeathsServiceLocal {

	@Autowired
	private USJuneDeathsDao juneDeathsDao;

	@Override
	public List<USJuneDeaths> getAllUSJuneDeathsEntries() {
		List<USJuneDeaths> aList = juneDeathsDao.findAllEntries();
		return aList;
	}

	@Override
	public USJuneDeaths getUSJuneDeathsEntryByCountryRegion(String countryRegion) {
		return juneDeathsDao.getEntryByCountryRegion(countryRegion);
	}

	@Override
	public USJuneDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return juneDeathsDao.findByCountryRegionProvinceState(countryRegion, provinceState);
	}

	@Override
	public List<USJuneDeaths> getEntryByProvenceState(String provenceState) {
		return juneDeathsDao.getEntryByProvenceState(provenceState);
	}

}
