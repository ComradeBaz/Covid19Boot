/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.months.confirmed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.dao.interfaces.USMayDao;
import com.domrade.entity.implementation.USMay;
import com.domrade.interfaces.months.confirmed.USMayServiceLocal;

/**
 *
 * @author David
 */
@Service
public class USMayService implements USMayServiceLocal {

	@Autowired
	private USMayDao mayDao;

	@Override
	public List<USMay> getAllUSMayEntries() {
		List<USMay> aList = mayDao.findAllEntries();
		return aList;
	}

	@Override
	public USMay getUSMayEntryByCountryRegion(String countryRegion) {
		return mayDao.getEntryByCountryRegion(countryRegion);
	}

	@Override
	public USMay findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return mayDao.findByCountryRegionProvinceState(countryRegion, provinceState);
	}

	@Override
	public List<USMay> getEntryByProvenceState(String provenceState) {
		return mayDao.getEntryByProvenceState(provenceState);
	}

}
