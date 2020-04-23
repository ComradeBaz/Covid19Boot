/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.dao.JpaDao;
import com.domrade.dao.interfaces.USMarchDeathsDao;
import com.domrade.entity.implementation.USMarchDeaths;

/**
 *
 * @author David
 */
@Service
public class JpaUSMarchDeathsDao extends JpaDao<Long, USMarchDeaths> implements USMarchDeathsDao {

	public JpaUSMarchDeathsDao() {
		super(USMarchDeaths.class);
	}

	@Override
	public List<USMarchDeaths> findAllEntries() {
		return entityManager.createNamedQuery("USMarchDeaths.findAllEntries").getResultList();
	}

	@Override
	public USMarchDeaths getEntryByCountryRegion(String countryRegion) {
		return (USMarchDeaths) entityManager.createNamedQuery("USMarchDeaths.findByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList().get(0);
	}

	@Override
	public USMarchDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return (USMarchDeaths) entityManager.createNamedQuery("USMarchDeaths.findByCountryRegionProvinceState")
				.setParameter("countryRegion", countryRegion).setParameter("provenceState", provinceState)
				.getResultList().get(0);
	}

	@Override
	public List<USMarchDeaths> getEntryByProvenceState(String provenceState) {
		return entityManager.createNamedQuery("USMarchDeaths.findByProvenceState")
				.setParameter("provenceState", provenceState).getResultList();
	}

}
