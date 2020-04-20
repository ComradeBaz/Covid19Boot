/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.months.confirmed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.dao.interfaces.MarchDao;
import com.domrade.entity.implementation.March;
import com.domrade.interfaces.months.confirmed.MarchServiceLocal;

/**
 *
 * @author David
 */
@Service
public class MarchService implements MarchServiceLocal {

	@Autowired
	private MarchDao marchDao;

	@Override
	public List<March> getAllMarchEntries() {
		List<March> aList = marchDao.findAllEntries();
		return aList;
	}

	@Override
	public March getMarchEntryByCountryRegion(String countryRegion) {
		return marchDao.getEntryByCountryRegion(countryRegion);
	}

	@Override
	public March findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return marchDao.findByCountryRegionProvinceState(countryRegion, provinceState);
	}

}
