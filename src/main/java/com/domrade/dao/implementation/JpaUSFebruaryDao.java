/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.implementation;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import com.domrade.dao.JpaDao;
import com.domrade.dao.interfaces.USFebruaryDao;
import com.domrade.entity.implementation.USFebruary;

/**
 *
 * @author David
 */
@Service
public class JpaUSFebruaryDao extends JpaDao<Long, USFebruary> implements USFebruaryDao {

	public JpaUSFebruaryDao() {
		super(USFebruary.class);
	}

	@Override
	public List<USFebruary> findAllEntries() {
		return entityManager.createNamedQuery("USFebruary.findAllEntries").getResultList();
	}

	@Override
	public USFebruary getEntryByCountryRegion(String countryRegion) {
		return (USFebruary) entityManager.createNamedQuery("USFebruary.findByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList().get(0);
	}

	@Override
	public List<String> getAllUSFebruaryCountries() {
		return entityManager.createNamedQuery("USFebruary.findAllCountryRegion").getResultList();
	}

	@Override
	public List<String> getProvinceStateByCountryRegion(String countryRegion) {
		return entityManager.createNamedQuery("USFebruary.findProvinceStateByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList();
	}

	@Override
	public USFebruary findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return (USFebruary) entityManager.createNamedQuery("USFebruary.findByCountryRegionProvinceState")
				.setParameter("countryRegion", countryRegion).setParameter("provenceState", provinceState)
				.getResultList().get(0);
	}

	@Override
	public List<String> getAllUSFebruaryCountryRegionProvinceState() {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> query = criteriaBuilder.createQuery(String.class);
		Root<USFebruary> februaryRoot = query.from(USFebruary.class);

		query.select(criteriaBuilder.concat(criteriaBuilder.concat(februaryRoot.<String>get("countryRegion"), " - "),
				februaryRoot.<String>get("provenceState")));
		TypedQuery<String> typedQuery = entityManager.createQuery(query);
		List<String> listOfLocations = typedQuery.getResultList();

		return listOfLocations;
	}

	@Override
	public List<USFebruary> getEntryByProvenceState(String provenceState) {
		return entityManager.createNamedQuery("USFebruary.findByProvenceState")
				.setParameter("provenceState", provenceState).getResultList();
	}

}
