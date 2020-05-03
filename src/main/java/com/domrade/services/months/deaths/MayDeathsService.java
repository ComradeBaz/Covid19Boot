/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.months.deaths;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.dao.interfaces.MayDeathsDao;
import com.domrade.entity.implementation.MayDeaths;
import com.domrade.interfaces.months.deaths.MayDeathsServiceLocal;

/**
 *
 * @author David
 */
@Service
public class MayDeathsService implements MayDeathsServiceLocal {

	@Autowired
	private MayDeathsDao mayDeathsDao;

	@Override
	public List<MayDeaths> getAllMayDeathsEntries() {
		List<MayDeaths> aList = mayDeathsDao.findAllEntries();
		return aList;
	}

	@Override
	public MayDeaths getMayDeathsEntryByCountryRegion(String countryRegion) {
		return mayDeathsDao.getEntryByCountryRegion(countryRegion);
	}

	@Override
	public MayDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return mayDeathsDao.findByCountryRegionProvinceState(countryRegion, provinceState);
	}

}
