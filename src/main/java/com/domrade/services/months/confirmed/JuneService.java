/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.months.confirmed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.dao.interfaces.JuneDao;
import com.domrade.entity.implementation.June;
import com.domrade.interfaces.months.confirmed.JuneServiceLocal;

/**
 *
 * @author David
 */
@Service
public class JuneService implements JuneServiceLocal {

	@Autowired
	private JuneDao juneDao;

	@Override
	public List<June> getAllJuneEntries() {
		List<June> aList = juneDao.findAllEntries();
		return aList;
	}

	@Override
	public June getJuneEntryByCountryRegion(String countryRegion) {
		return juneDao.getEntryByCountryRegion(countryRegion);
	}

	@Override
	public June findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return juneDao.findByCountryRegionProvinceState(countryRegion, provinceState);
	}

}
