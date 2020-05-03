/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.months.confirmed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.dao.interfaces.MayDao;
import com.domrade.entity.implementation.May;
import com.domrade.interfaces.months.confirmed.MayServiceLocal;

/**
 *
 * @author David
 */
@Service
public class MayService implements MayServiceLocal {

	@Autowired
	private MayDao mayDao;

	@Override
	public List<May> getAllMayEntries() {
		List<May> aList = mayDao.findAllEntries();
		return aList;
	}

	@Override
	public May getMayEntryByCountryRegion(String countryRegion) {
		return mayDao.getEntryByCountryRegion(countryRegion);
	}

	@Override
	public May findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return mayDao.findByCountryRegionProvinceState(countryRegion, provinceState);
	}

}
