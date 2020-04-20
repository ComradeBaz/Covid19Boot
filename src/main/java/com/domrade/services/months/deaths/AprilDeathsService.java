/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.months.deaths;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.dao.interfaces.AprilDeathsDao;
import com.domrade.entity.implementation.AprilDeaths;
import com.domrade.interfaces.months.deaths.AprilDeathsServiceLocal;

/**
 *
 * @author David
 */
@Service
public class AprilDeathsService implements AprilDeathsServiceLocal {

	@Autowired
	private AprilDeathsDao aprilDeathsDao;

	@Override
	public List<AprilDeaths> getAllAprilDeathsEntries() {
		List<AprilDeaths> aList = aprilDeathsDao.findAllEntries();
		for (AprilDeaths a : aList) {
		}
		return aList;
	}

	@Override
	public AprilDeaths getAprilDeathsEntryByCountryRegion(String countryRegion) {
		return aprilDeathsDao.getEntryByCountryRegion(countryRegion);
	}

	@Override
	public AprilDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return aprilDeathsDao.findByCountryRegionProvinceState(countryRegion, provinceState);
	}

}
