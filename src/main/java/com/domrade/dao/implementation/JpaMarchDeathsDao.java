/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.dao.JpaDao;
import com.domrade.dao.interfaces.MarchDeathsDao;
import com.domrade.entity.implementation.MarchDeaths;

/**
 *
 * @author David
 */
@Service
public class JpaMarchDeathsDao extends JpaDao<Long, MarchDeaths> implements MarchDeathsDao {

	public JpaMarchDeathsDao() {
		super(MarchDeaths.class);
	}

	@Override
	public List<MarchDeaths> findAllEntries() {
		return entityManager.createNamedQuery("MarchDeaths.findAllEntries").getResultList();
	}

	@Override
	public MarchDeaths getEntryByCountryRegion(String countryRegion) {
		return (MarchDeaths) entityManager.createNamedQuery("MarchDeaths.findByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList().get(0);
	}

	@Override
	public MarchDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return (MarchDeaths) entityManager.createNamedQuery("MarchDeaths.findByCountryRegionProvinceState")
				.setParameter("countryRegion", countryRegion).setParameter("provenceState", provinceState)
				.getResultList().get(0);
	}

}
