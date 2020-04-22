/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.USMarch;

/**
 *
 * @author David
 */
@Service
public interface USMarchDao extends Dao<Long, USMarch> {

	public List<USMarch> findAllEntries();

	public USMarch getEntryByCountryRegion(String countryRegion);

	public USMarch findByCountryRegionProvinceState(String countryRegion, String provinceState);

}
