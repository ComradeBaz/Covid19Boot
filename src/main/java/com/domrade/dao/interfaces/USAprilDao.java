/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.USApril;

/**
 *
 * @author David
 */
@Service
public interface USAprilDao extends Dao<Long, USApril> {

	public List<USApril> findAllEntries();

	public USApril getEntryByCountryRegion(String countryRegion);

	public USApril findByCountryRegionProvinceState(String countryRegion, String provinceState);

}
