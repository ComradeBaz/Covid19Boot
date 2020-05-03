/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.dao.JpaDao;
import com.domrade.dao.interfaces.MayDao;
import com.domrade.entity.implementation.May;

/**
 *
 * @author David
 */
@Service
public class JpaMayDao extends JpaDao<Long, May> implements MayDao {

	public JpaMayDao() {
		super(May.class);
	}

	@Override
	public List<May> findAllEntries() {
		return entityManager.createNamedQuery("May.findAllEntries").getResultList();
	}

	@Override
	public May getEntryByCountryRegion(String countryRegion) {
		return (May) entityManager.createNamedQuery("May.findByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList().get(0);
	}

	@Override
	public May findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return (May) entityManager.createNamedQuery("May.findByCountryRegionProvinceState")
				.setParameter("countryRegion", countryRegion).setParameter("provenceState", provinceState)
				.getResultList().get(0);
	}

}
