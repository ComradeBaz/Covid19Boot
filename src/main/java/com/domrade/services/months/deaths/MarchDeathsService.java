/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.months.deaths;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.dao.interfaces.MarchDeathsDao;
import com.domrade.entity.implementation.MarchDeaths;
import com.domrade.interfaces.months.deaths.MarchDeathsServiceLocal;

/**
 *
 * @author David
 */
@Service
public class MarchDeathsService implements MarchDeathsServiceLocal {

	@Autowired
	private MarchDeathsDao marchDeathsDao;

	@Override
	public List<MarchDeaths> getAllMarchDeathsEntries() {
		List<MarchDeaths> aList = marchDeathsDao.findAllEntries();
		return aList;
	}

	@Override
	public MarchDeaths getMarchDeathsEntryByCountryRegion(String countryRegion) {
		return marchDeathsDao.getEntryByCountryRegion(countryRegion);
	}

	@Override
	public MarchDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return marchDeathsDao.findByCountryRegionProvinceState(countryRegion, provinceState);
	}

}
