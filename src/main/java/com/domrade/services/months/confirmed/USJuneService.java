/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.months.confirmed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.dao.interfaces.USJuneDao;
import com.domrade.entity.implementation.USJune;
import com.domrade.interfaces.months.confirmed.USJuneServiceLocal;

/**
 *
 * @author David
 */
@Service
public class USJuneService implements USJuneServiceLocal {

	@Autowired
	private USJuneDao juneDao;

	@Override
	public List<USJune> getAllUSJuneEntries() {
		List<USJune> aList = juneDao.findAllEntries();
		return aList;
	}

	@Override
	public USJune getUSJuneEntryByCountryRegion(String countryRegion) {
		return juneDao.getEntryByCountryRegion(countryRegion);
	}

	@Override
	public USJune findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return juneDao.findByCountryRegionProvinceState(countryRegion, provinceState);
	}

	@Override
	public List<USJune> getEntryByProvenceState(String provenceState) {
		return juneDao.getEntryByProvenceState(provenceState);
	}

}
