/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.months.confirmed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.dao.interfaces.JanuaryDao;
import com.domrade.entity.implementation.January;
import com.domrade.interfaces.months.confirmed.JanuaryServiceLocal;

/**
 *
 * @author David
 */
@Service
public class JanuaryService implements JanuaryServiceLocal {

	@Autowired
	private JanuaryDao januaryDao;

	@Override
	public List<January> getAllJanuaryEntries() {
		List<January> aList = januaryDao.findAllEntries();
		return aList;
	}

	@Override
	public January getJanuaryEntryByCountryRegion(String countryRegion) {
		return januaryDao.getEntryByCountryRegion(countryRegion);
	}

	@Override
	public January findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return januaryDao.findByCountryRegionProvinceState(countryRegion, provinceState);
	}

}
