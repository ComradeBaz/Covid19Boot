package com.domrade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.domrade.entity.implementation.UsStates;

@Repository
public interface IUsStatesRepository extends PagingAndSortingRepository<UsStates, Long> {

	@Query(value = "SELECT s.state FROM UsStates s")
	public List<String> findAllStates();

	@Query(value = "SELECT s.id FROM UsStates s")
	public List<Long> findAllStateIds();

	@Query(value = "SELECT s.state FROM UsStates s WHERE s.id =:stateId")
	public String getStateNameById(long stateId);

}
