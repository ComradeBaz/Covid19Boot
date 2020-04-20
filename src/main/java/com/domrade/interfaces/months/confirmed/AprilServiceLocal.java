/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.interfaces.months.confirmed;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.April;

/**
 *
 * @author David
 */
@Service
public interface AprilServiceLocal {

	public List<April> getAllAprilEntries();

	public April getAprilEntryByCountryRegion(String countryRegion);

	public April findByCountryRegionProvinceState(String countryRegion, String provinceState);

}
