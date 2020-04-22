/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.dao.JpaDao;
import com.domrade.dao.interfaces.USAprilDeathsDao;
import com.domrade.entity.implementation.USAprilDeaths;

/**
 *
 * @author David
 */
@Service
public class JpaUSAprilDeathsDao extends JpaDao<Long, USAprilDeaths> implements USAprilDeathsDao {

	public JpaUSAprilDeathsDao() {
		super(USAprilDeaths.class);
	}

	@Override
	public List<USAprilDeaths> findAllEntries() {
		return entityManager.createNamedQuery("USAprilDeaths.findAllEntries").getResultList();
	}

	@Override
	public USAprilDeaths getEntryByCountryRegion(String countryRegion) {
		return (USAprilDeaths) entityManager.createNamedQuery("USAprilDeaths.findByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList().get(0);
	}

	@Override
	public USAprilDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return (USAprilDeaths) entityManager.createNamedQuery("USAprilDeaths.findByCountryRegionProvinceState")
				.setParameter("countryRegion", countryRegion).setParameter("provenceState", provinceState)
				.getResultList().get(0);
	}

}
