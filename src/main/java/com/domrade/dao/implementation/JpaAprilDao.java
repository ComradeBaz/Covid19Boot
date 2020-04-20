/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.dao.JpaDao;
import com.domrade.dao.interfaces.AprilDao;
import com.domrade.entity.implementation.April;

/**
 *
 * @author David
 */
@Service
public class JpaAprilDao extends JpaDao<Long, April> implements AprilDao {

	public JpaAprilDao() {
		super(April.class);
	}

	@Override
	public List<April> findAllEntries() {
		return entityManager.createNamedQuery("April.findAllEntries").getResultList();
	}

	@Override
	public April getEntryByCountryRegion(String countryRegion) {
		return (April) entityManager.createNamedQuery("April.findByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList().get(0);
	}

	@Override
	public April findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return (April) entityManager.createNamedQuery("April.findByCountryRegionProvinceState")
				.setParameter("countryRegion", countryRegion).setParameter("provenceState", provinceState)
				.getResultList().get(0);
	}

}
