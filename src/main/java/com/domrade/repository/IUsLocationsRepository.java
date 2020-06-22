package com.domrade.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.domrade.entity.implementation.UsLocations;

@Repository
public interface IUsLocationsRepository extends PagingAndSortingRepository<UsLocations, Long> {

	@Query(value = "SELECT l.id FROM UsLocations l WHERE l.stateId =:stateId")
	public List<Long> getLocationIdsByStateId(long stateId);

	@Query(value = "SELECT l.county FROM UsLocations l WHERE l.id =:id")
	public String getCountyNameByLocationId(long id);

	@Query(value = "SELECT l.county FROM UsLocations l WHERE l.stateId =:stateId")
	public ArrayList<String> getCountyNamesByStateId(long stateId);

	// Get ids for US Locations
	@Query(value = "SELECT DISTINCT u.id FROM UsLocations u")
	public List<Long> getUsLocationIds();

}
