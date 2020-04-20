/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.interfaces.months.deaths;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.AprilDeaths;

/**
 *
 * @author David
 */
@Service
public interface AprilDeathsServiceLocal {

	public List<AprilDeaths> getAllAprilDeathsEntries();

	public AprilDeaths getAprilDeathsEntryByCountryRegion(String countryRegion);

	public AprilDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState);

}
