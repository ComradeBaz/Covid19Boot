/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.months.confirmed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.dao.interfaces.AprilDao;
import com.domrade.entity.implementation.April;
import com.domrade.interfaces.months.confirmed.AprilServiceLocal;

/**
 *
 * @author David
 */
@Service
public class AprilService implements AprilServiceLocal {

	@Autowired
	private AprilDao aprilDao;

	@Override
	public List<April> getAllAprilEntries() {
		List<April> aList = aprilDao.findAllEntries();
		for (April a : aList) {
		}
		return aList;
	}

	@Override
	public April getAprilEntryByCountryRegion(String countryRegion) {
		return aprilDao.getEntryByCountryRegion(countryRegion);
	}

	@Override
	public April findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return aprilDao.findByCountryRegionProvinceState(countryRegion, provinceState);
	}

}
