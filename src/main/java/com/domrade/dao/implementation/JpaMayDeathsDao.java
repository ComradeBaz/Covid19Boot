/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.dao.JpaDao;
import com.domrade.dao.interfaces.MayDeathsDao;
import com.domrade.entity.implementation.MayDeaths;

/**
 *
 * @author David
 */
@Service
public class JpaMayDeathsDao extends JpaDao<Long, MayDeaths> implements MayDeathsDao {

	public JpaMayDeathsDao() {
		super(MayDeaths.class);
	}

	@Override
	public List<MayDeaths> findAllEntries() {
		return entityManager.createNamedQuery("MayDeaths.findAllEntries").getResultList();
	}

	@Override
	public MayDeaths getEntryByCountryRegion(String countryRegion) {
		return (MayDeaths) entityManager.createNamedQuery("MayDeaths.findByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList().get(0);
	}

	@Override
	public MayDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return (MayDeaths) entityManager.createNamedQuery("MayDeaths.findByCountryRegionProvinceState")
				.setParameter("countryRegion", countryRegion).setParameter("provenceState", provinceState)
				.getResultList().get(0);
	}

}
