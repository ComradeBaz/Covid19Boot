/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.months.deaths;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.dao.interfaces.JanuaryDeathsDao;
import com.domrade.entity.implementation.JanuaryDeaths;
import com.domrade.interfaces.months.deaths.JanuaryDeathsServiceLocal;

/**
 *
 * @author David
 */
@Service
public class JanuaryDeathsService implements JanuaryDeathsServiceLocal {

	@Autowired
	private JanuaryDeathsDao januaryDeathsDao;

	@Override
	public List<JanuaryDeaths> getAllJanuaryDeathsEntries() {
		List<JanuaryDeaths> aList = januaryDeathsDao.findAllEntries();
		return aList;
	}

	@Override
	public JanuaryDeaths getJanuaryDeathsEntryByCountryRegion(String countryRegion) {
		return januaryDeathsDao.getEntryByCountryRegion(countryRegion);
	}

	@Override
	public JanuaryDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return januaryDeathsDao.findByCountryRegionProvinceState(countryRegion, provinceState);
	}

}
