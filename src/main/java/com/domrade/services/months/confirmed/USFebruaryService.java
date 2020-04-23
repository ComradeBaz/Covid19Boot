/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.months.confirmed;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.dao.interfaces.USFebruaryDao;
import com.domrade.entity.implementation.USFebruary;
import com.domrade.interfaces.months.confirmed.USFebruaryServiceLocal;

/**
 *
 * @author David
 */
@Service
public class USFebruaryService implements USFebruaryServiceLocal {

	@Autowired
	private USFebruaryDao februaryDao;

	@Override
	public List<USFebruary> getAllUSFebruaryEntries() {
		List<USFebruary> aList = februaryDao.findAllEntries();
		return aList;
	}

	@Override
	public USFebruary getUSFebruaryEntryByCountryRegion(String countryRegion) {
		return februaryDao.getEntryByCountryRegion(countryRegion);
	}

	@Override
	public List<String> getAllCountries() {
		return februaryDao.getAllUSFebruaryCountries();
	}

	@Override
	public List<String> getProvinceStateByCountryRegion(String countryRegion) {
		return februaryDao.getProvinceStateByCountryRegion(countryRegion);
	}

	@Override
	public USFebruary findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return februaryDao.findByCountryRegionProvinceState(countryRegion, provinceState);
	}

	@Override
	public List<String> getAllUSFebruaryCountryRegionProvinceState() {
		List<String> listOfLocations = februaryDao.getAllUSFebruaryCountryRegionProvinceState();
		List<String> sortedListOfLocations = new ArrayList<>();
		String originalLocation;
		String formattedLocation;
		int stringSize;
		for (String s : listOfLocations) {
			originalLocation = s.trim();
			stringSize = originalLocation.length();
			if (Character.valueOf(originalLocation.charAt(stringSize - 1)).compareTo('-') == 0) {
				formattedLocation = originalLocation.substring(0, stringSize - 2);
				sortedListOfLocations.add(formattedLocation);
			} else {
				sortedListOfLocations.add(originalLocation);
			}
		}
		sortedListOfLocations.sort(Comparator.comparing(String::toString));

		return sortedListOfLocations;
	}

	@Override
	public List<USFebruary> getEntryByProvenceState(String provenceState) {
		return februaryDao.getEntryByProvenceState(provenceState);
	}
}
