/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.months.confirmed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.dao.interfaces.USAprilDao;
import com.domrade.entity.implementation.USApril;
import com.domrade.interfaces.months.confirmed.USAprilServiceLocal;

/**
 *
 * @author David
 */
@Service
public class USAprilService implements USAprilServiceLocal {

	@Autowired
	private USAprilDao aprilDao;

	@Override
	public List<USApril> getAllUSAprilEntries() {
		List<USApril> aList = aprilDao.findAllEntries();
		for (USApril a : aList) {
		}
		return aList;
	}

	@Override
	public USApril getUSAprilEntryByCountryRegion(String countryRegion) {
		return aprilDao.getEntryByCountryRegion(countryRegion);
	}

	@Override
	public USApril findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return aprilDao.findByCountryRegionProvinceState(countryRegion, provinceState);
	}

}
