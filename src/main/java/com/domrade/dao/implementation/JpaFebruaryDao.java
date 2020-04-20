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
import com.domrade.dao.interfaces.FebruaryDao;
import com.domrade.entity.implementation.February;

/**
 *
 * @author David
 */
@Service
public class JpaFebruaryDao extends JpaDao<Long, February> implements FebruaryDao {

	public JpaFebruaryDao() {
		super(February.class);
	}

	@Override
	public List<February> findAllEntries() {
		return entityManager.createNamedQuery("February.findAllEntries").getResultList();
	}

	@Override
	public February getEntryByCountryRegion(String countryRegion) {
		return (February) entityManager.createNamedQuery("February.findByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList().get(0);
	}

	@Override
	public List<String> getAllFebruaryCountries() {
		return entityManager.createNamedQuery("February.findAllCountryRegion").getResultList();
	}

	@Override
	public List<String> getProvinceStateByCountryRegion(String countryRegion) {
		return entityManager.createNamedQuery("February.findProvinceStateByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList();
	}

	@Override
	public February findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return (February) entityManager.createNamedQuery("February.findByCountryRegionProvinceState")
				.setParameter("countryRegion", countryRegion).setParameter("provenceState", provinceState)
				.getResultList().get(0);
	}

	@Override
	public List<String> getAllFebruaryCountryRegionProvinceState() {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> query = criteriaBuilder.createQuery(String.class);
		Root<February> februaryRoot = query.from(February.class);

		query.select(criteriaBuilder.concat(criteriaBuilder.concat(februaryRoot.<String>get("countryRegion"), " - "),
				februaryRoot.<String>get("provenceState")));
		TypedQuery<String> typedQuery = entityManager.createQuery(query);
		List<String> listOfLocations = typedQuery.getResultList();

		return listOfLocations;
	}

}
