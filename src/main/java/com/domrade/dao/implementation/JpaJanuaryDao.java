/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.dao.JpaDao;
import com.domrade.dao.interfaces.JanuaryDao;
import com.domrade.entity.implementation.January;

/**
 *
 * @author David
 */
@Service
public class JpaJanuaryDao extends JpaDao<Long, January> implements JanuaryDao {

	public JpaJanuaryDao() {
		super(January.class);
	}

	@Override
	public List<January> findAllEntries() {
		return entityManager.createNamedQuery("January.findAllEntries").getResultList();
	}

	@Override
	public January getEntryByCountryRegion(String countryRegion) {
		return (January) entityManager.createNamedQuery("January.findByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList().get(0);
	}

	@Override
	public January findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return (January) entityManager.createNamedQuery("January.findByCountryRegionProvinceState")
				.setParameter("countryRegion", countryRegion).setParameter("provenceState", provinceState)
				.getResultList().get(0);
	}

}
