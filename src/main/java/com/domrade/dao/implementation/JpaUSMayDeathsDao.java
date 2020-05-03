/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.dao.JpaDao;
import com.domrade.dao.interfaces.USMayDeathsDao;
import com.domrade.entity.implementation.USMayDeaths;

/**
 *
 * @author David
 */
@Service
public class JpaUSMayDeathsDao extends JpaDao<Long, USMayDeaths> implements USMayDeathsDao {

	public JpaUSMayDeathsDao() {
		super(USMayDeaths.class);
	}

	@Override
	public List<USMayDeaths> findAllEntries() {
		return entityManager.createNamedQuery("USMayDeaths.findAllEntries").getResultList();
	}

	@Override
	public USMayDeaths getEntryByCountryRegion(String countryRegion) {
		return (USMayDeaths) entityManager.createNamedQuery("USMayDeaths.findByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList().get(0);
	}

	@Override
	public USMayDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return (USMayDeaths) entityManager.createNamedQuery("USMayDeaths.findByCountryRegionProvinceState")
				.setParameter("countryRegion", countryRegion).setParameter("provenceState", provinceState)
				.getResultList().get(0);
	}

	@Override
	public List<USMayDeaths> getEntryByProvenceState(String provenceState) {
		return entityManager.createNamedQuery("USMayDeaths.findByProvenceState")
				.setParameter("provenceState", provenceState).getResultList();
	}

}
