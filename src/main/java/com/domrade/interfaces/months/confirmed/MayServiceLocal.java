/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.interfaces.months.confirmed;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.May;

/**
 *
 * @author David
 */
@Service
public interface MayServiceLocal {

	public List<May> getAllMayEntries();

	public May getMayEntryByCountryRegion(String countryRegion);

	public May findByCountryRegionProvinceState(String countryRegion, String provinceState);
}
