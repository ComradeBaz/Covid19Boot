/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.dao.JpaDao;
import com.domrade.dao.interfaces.AprilDeathsDao;
import com.domrade.entity.implementation.AprilDeaths;

/**
 *
 * @author David
 */
@Service
public class JpaAprilDeathsDao extends JpaDao<Long, AprilDeaths> implements AprilDeathsDao {

	public JpaAprilDeathsDao() {
		super(AprilDeaths.class);
	}

	@Override
	public List<AprilDeaths> findAllEntries() {
		return entityManager.createNamedQuery("AprilDeaths.findAllEntries").getResultList();
	}

	@Override
	public AprilDeaths getEntryByCountryRegion(String countryRegion) {
		return (AprilDeaths) entityManager.createNamedQuery("AprilDeaths.findByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList().get(0);
	}

	@Override
	public AprilDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return (AprilDeaths) entityManager.createNamedQuery("AprilDeaths.findByCountryRegionProvinceState")
				.setParameter("countryRegion", countryRegion).setParameter("provenceState", provinceState)
				.getResultList().get(0);
	}

}
