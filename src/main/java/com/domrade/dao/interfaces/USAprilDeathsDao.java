/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.USAprilDeaths;

/**
 *
 * @author David
 */
@Service
public interface USAprilDeathsDao extends Dao<Long, USAprilDeaths> {

	public List<USAprilDeaths> findAllEntries();

	public USAprilDeaths getEntryByCountryRegion(String countryRegion);

	public USAprilDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState);

	public List<USAprilDeaths> getEntryByProvenceState(String provenceState);

}
