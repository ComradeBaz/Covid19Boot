package com.domrade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.domrade.entity.implementation.GlobalLocation;

@Repository
public interface IGlobalLocationRepository extends PagingAndSortingRepository<GlobalLocation, Long> {

	@Query(value = "SELECT g.location FROM GlobalLocation g ORDER BY g.location ASC")
	public List<String> findAllGlobalLocationNames();

	@Query(value = "SELECT g.id FROM GlobalLocation g ORDER BY g.location ASC")
	public List<Long> findAllGlobalLocationIds();

	@Query(value = "SELECT g.location FROM GlobalLocation g WHERE g.id =:id")
	public String getLocationNameById(long id);

}
