/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.months.confirmed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.dao.interfaces.USMarchDao;
import com.domrade.entity.implementation.USMarch;
import com.domrade.interfaces.months.confirmed.USMarchServiceLocal;

/**
 *
 * @author David
 */
@Service
public class USMarchService implements USMarchServiceLocal {

	@Autowired
	private USMarchDao marchDao;

	@Override
	public List<USMarch> getAllUSMarchEntries() {
		List<USMarch> aList = marchDao.findAllEntries();
		return aList;
	}

	@Override
	public USMarch getUSMarchEntryByCountryRegion(String countryRegion) {
		return marchDao.getEntryByCountryRegion(countryRegion);
	}

	@Override
	public USMarch findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return marchDao.findByCountryRegionProvinceState(countryRegion, provinceState);
	}

}
