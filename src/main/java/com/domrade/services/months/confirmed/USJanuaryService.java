/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.months.confirmed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.dao.interfaces.USJanuaryDao;
import com.domrade.entity.implementation.USJanuary;
import com.domrade.interfaces.months.confirmed.USJanuaryServiceLocal;

/**
 *
 * @author David
 */
@Service
public class USJanuaryService implements USJanuaryServiceLocal {

	@Autowired
	private USJanuaryDao januaryDao;

	@Override
	public List<USJanuary> getAllUSJanuaryEntries() {
		List<USJanuary> aList = januaryDao.findAllEntries();
		return aList;
	}

	@Override
	public USJanuary getUSJanuaryEntryByCountryRegion(String countryRegion) {
		return januaryDao.getEntryByCountryRegion(countryRegion);
	}

	@Override
	public USJanuary findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return januaryDao.findByCountryRegionProvinceState(countryRegion, provinceState);
	}

}
