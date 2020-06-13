/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.months.deaths;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.dao.interfaces.JuneDeathsDao;
import com.domrade.entity.implementation.JuneDeaths;
import com.domrade.interfaces.months.deaths.JuneDeathsServiceLocal;

/**
 *
 * @author David
 */
@Service
public class JuneDeathsService implements JuneDeathsServiceLocal {

	@Autowired
	private JuneDeathsDao juneDeathsDao;

	@Override
	public List<JuneDeaths> getAllJuneDeathsEntries() {
		List<JuneDeaths> aList = juneDeathsDao.findAllEntries();
		return aList;
	}

	@Override
	public JuneDeaths getJuneDeathsEntryByCountryRegion(String countryRegion) {
		return juneDeathsDao.getEntryByCountryRegion(countryRegion);
	}

	@Override
	public JuneDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return juneDeathsDao.findByCountryRegionProvinceState(countryRegion, provinceState);
	}

}
