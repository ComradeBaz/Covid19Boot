package com.domrade.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.domrade.entity.implementation.CovidData;

@Repository
public interface ICovidDataRepository extends PagingAndSortingRepository<CovidData, Long> {

	@Query(value = "SELECT c.data FROM CovidData c WHERE c.location =:location AND c.type =:type ORDER BY c.date ASC")
	List<Integer> getCovidDataByLocationAndType(long location, String type);

	@Query(value = "SELECT c.date FROM CovidData c WHERE c.location =:location AND c.type =:type ORDER BY c.date ASC")
	ArrayList<Date> getCovidDateByLocationAndType(long location, String type);

	// Get the sum of data for states by adding the sum for each county for a given
	// date
	@Query(value = "SELECT SUM(c.data) FROM CovidData c WHERE c.location IN (SELECT u.id FROM UsLocations u WHERE u.stateId = "
			+ "(SELECT s.id FROM UsStates s WHERE s.state =:stateName)) AND c.date =:date AND c.type =:type")
	int getSumForState(String stateName, Date date, String type);

	// Get the dates of data for a given state
	@Query(value = "SELECT DISTINCT c.date FROM CovidData c WHERE c.location IN (SELECT u.id FROM UsLocations u WHERE u.stateId = "
			+ "(SELECT s.id FROM UsStates s WHERE s.state =:stateName)) AND c.type =:type ORDER BY c.date ASC")
	ArrayList<Date> getDatesOfDataForState(String stateName, String type);

	// Get the dates of data for a given US or Global location by locationId
	@Query(value = "SELECT DISTINCT c.date from CovidData c WHERE c.location =:locationId AND c.type =:type ORDER BY c.date ASC")
	ArrayList<Date> getDatesOfDataForLocationByType(long locationId, String type);

	// Get Dates
	@Query(value = "SELECT DISTINCT c.date FROM CovidData c ORDER BY c.date ASC")
	ArrayList<Date> getDates();

	// Get data by id, date and type
	@Query(value = "SELECT c.data FROM CovidData c WHERE c.location =:id AND c.date =:d AND c.type =:type")
	int getDataByIdDateType(Long id, Date d, String type);

	// Get the maximum date
	@Query(value = "SELECT MAX(date) from CovidData c")
	Date getMaxDate();
}
