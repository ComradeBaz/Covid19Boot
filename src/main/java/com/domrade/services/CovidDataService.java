package com.domrade.services;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.interfaces.local.CovidDataLocal;
import com.domrade.repository.ICovidDataRepository;

@Service
public class CovidDataService implements CovidDataLocal {

	@Autowired
	private ICovidDataRepository covidDataRepository;

	public CovidDataService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Integer> getCovidDataByLocationAndType(long location, String type) {
		// Get a list of data for all dates
		return covidDataRepository.getCovidDataByLocationAndType(location, type);
	}

	@Override
	public List<Date> getCovidDateByLocationAndType(long location, String type) {
		// Get a list of dates for data by location
		return covidDataRepository.getCovidDateByLocationAndType(location, type);
	}

	@Override
	public int getSumForState(String stateName, Date date, String type) {
		// Get the sum of data for all counties in a given state for a given date
		return covidDataRepository.getSumForState(stateName, date, type);
	}

	@Override
	public ArrayList<Date> getDatesOfDataForState(String stateName, String type) {
		// Get the dates for which there is a data entry for a given state
		return covidDataRepository.getDatesOfDataForState(stateName, type);
	}

	@Override
	public ArrayList<Date> getDates() {
		return covidDataRepository.getDates();
	}

	@Override
	public int getDataByIdDateType(Long id, Date d, String type) {
		return covidDataRepository.getDataByIdDateType(id, d, type);
	}

	@Override
	public String getMaxDate() {
		// Get the last date for which there is data in CovidData
		Date maxDate = covidDataRepository.getMaxDate();
		SimpleDateFormat sdf = new SimpleDateFormat("MMMdd");
		return sdf.format(maxDate);
	}

	@Override
	public ArrayList<Date> getDatesOfDataForLocationByType(long locationId, String type) {
		// Get the dates for which there is a data entry for a given locationId
		return covidDataRepository.getDatesOfDataForLocationByType(locationId, type);
	}

}
