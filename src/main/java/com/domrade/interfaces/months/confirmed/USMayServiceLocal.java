/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.interfaces.months.confirmed;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.USMay;

/**
 *
 * @author David
 */
@Service
public interface USMayServiceLocal {

	public List<USMay> getAllUSMayEntries();

	public USMay getUSMayEntryByCountryRegion(String countryRegion);

	public USMay findByCountryRegionProvinceState(String countryRegion, String provinceState);

	public List<USMay> getEntryByProvenceState(String provenceState);
}
