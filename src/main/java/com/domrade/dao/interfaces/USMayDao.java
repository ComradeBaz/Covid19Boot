/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.USMay;

/**
 *
 * @author David
 */
@Service
public interface USMayDao extends Dao<Long, USMay> {

	public List<USMay> findAllEntries();

	public USMay getEntryByCountryRegion(String countryRegion);

	public USMay findByCountryRegionProvinceState(String countryRegion, String provinceState);

	public List<USMay> getEntryByProvenceState(String provenceState);

}
