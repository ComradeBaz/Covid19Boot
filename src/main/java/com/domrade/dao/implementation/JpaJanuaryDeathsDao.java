/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.dao.JpaDao;
import com.domrade.dao.interfaces.JanuaryDeathsDao;
import com.domrade.entity.implementation.JanuaryDeaths;

/**
 *
 * @author David
 */
@Service
public class JpaJanuaryDeathsDao extends JpaDao<Long, JanuaryDeaths> implements JanuaryDeathsDao {

	public JpaJanuaryDeathsDao() {
		super(JanuaryDeaths.class);
	}

	@Override
	public List<JanuaryDeaths> findAllEntries() {
		return entityManager.createNamedQuery("JanuaryDeaths.findAllEntries").getResultList();
	}

	@Override
	public JanuaryDeaths getEntryByCountryRegion(String countryRegion) {
		return (JanuaryDeaths) entityManager.createNamedQuery("JanuaryDeaths.findByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList().get(0);
	}

	@Override
	public JanuaryDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return (JanuaryDeaths) entityManager.createNamedQuery("JanuaryDeaths.findByCountryRegionProvinceState")
				.setParameter("countryRegion", countryRegion).setParameter("provenceState", provinceState)
				.getResultList().get(0);
	}

}
