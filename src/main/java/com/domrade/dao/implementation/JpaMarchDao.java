/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.dao.JpaDao;
import com.domrade.dao.interfaces.MarchDao;
import com.domrade.entity.implementation.March;

/**
 *
 * @author David
 */
@Service
public class JpaMarchDao extends JpaDao<Long, March> implements MarchDao {

	public JpaMarchDao() {
		super(March.class);
	}

	@Override
	public List<March> findAllEntries() {
		return entityManager.createNamedQuery("March.findAllEntries").getResultList();
	}

	@Override
	public March getEntryByCountryRegion(String countryRegion) {
		return (March) entityManager.createNamedQuery("March.findByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList().get(0);
	}

	@Override
	public March findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return (March) entityManager.createNamedQuery("March.findByCountryRegionProvinceState")
				.setParameter("countryRegion", countryRegion).setParameter("provenceState", provinceState)
				.getResultList().get(0);
	}

}
