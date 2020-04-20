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

import com.domrade.dao.interfaces.FebruaryDao;
import com.domrade.entity.implementation.February;
import com.domrade.interfaces.months.confirmed.FebruaryServiceLocal;

/**
 *
 * @author David
 */
@Service
public class FebruaryService implements FebruaryServiceLocal {

	@Autowired
	private FebruaryDao februaryDao;

	@Override
	public List<February> getAllFebruaryEntries() {
		List<February> aList = februaryDao.findAllEntries();
		return aList;
	}

	@Override
	public February getFebruaryEntryByCountryRegion(String countryRegion) {
		return februaryDao.getEntryByCountryRegion(countryRegion);
	}

	@Override
	public List<String> getAllCountries() {
		return februaryDao.getAllFebruaryCountries();
	}

	@Override
	public List<String> getProvinceStateByCountryRegion(String countryRegion) {
		return februaryDao.getProvinceStateByCountryRegion(countryRegion);
	}

	@Override
	public February findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return februaryDao.findByCountryRegionProvinceState(countryRegion, provinceState);
	}

	@Override
	public List<String> getAllFebruaryCountryRegionProvinceState() {
		List<String> listOfLocations = februaryDao.getAllFebruaryCountryRegionProvinceState();
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
}
