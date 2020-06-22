package com.domrade.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.UsLocations;
import com.domrade.interfaces.local.UsLocationsLocal;
import com.domrade.repository.IUsLocationsRepository;

@Service
public class UsLocationsService implements UsLocationsLocal {

	@Autowired
	private IUsLocationsRepository usRepository;

	public UsLocationsService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<UsLocations> findAll() {
		List<UsLocations> returnList = new ArrayList<>();
		Iterable<UsLocations> locationsIterable = usRepository.findAll();
		locationsIterable.forEach(returnList::add);

		return returnList;
	}

	@Override
	public List<Long> getCountiesByStateId(long stateId) {
		return usRepository.getLocationIdsByStateId(stateId);
	}

	@Override
	public String getCountyNameByLocationId(long id) {
		return usRepository.getCountyNameByLocationId(id);
	}

	@Override
	public ArrayList<String> getCountyNamesByStateId(long stateId) {
		return usRepository.getCountyNamesByStateId(stateId);
	}

	@Override
	public List<Long> getUsLocationIds() {
		return usRepository.getUsLocationIds();
	}

}
