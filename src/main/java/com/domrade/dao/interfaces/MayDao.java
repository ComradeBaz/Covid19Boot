/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.May;

/**
 *
 * @author David
 */
@Service
public interface MayDao extends Dao<Long, May> {

	public List<May> findAllEntries();

	public May getEntryByCountryRegion(String countryRegion);

	public May findByCountryRegionProvinceState(String countryRegion, String provinceState);

}
