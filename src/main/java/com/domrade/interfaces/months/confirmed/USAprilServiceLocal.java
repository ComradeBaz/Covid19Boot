/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.interfaces.months.confirmed;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.USApril;

/**
 *
 * @author David
 */
@Service
public interface USAprilServiceLocal {

	public List<USApril> getAllUSAprilEntries();

	public USApril getUSAprilEntryByCountryRegion(String countryRegion);

	public USApril findByCountryRegionProvinceState(String countryRegion, String provinceState);

}
