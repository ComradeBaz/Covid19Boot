package com.domrade.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.GlobalLocation;
import com.domrade.interfaces.local.GlobalLocationLocal;
import com.domrade.repository.IGlobalLocationRepository;

@Service
public class GlobalLocationService implements GlobalLocationLocal {

	@Autowired
	private IGlobalLocationRepository globalLocationRepository;

	public GlobalLocationService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<GlobalLocation> findAllGlobalLocations() {
		Iterable<GlobalLocation> results = globalLocationRepository.findAll();
		List<GlobalLocation> returnList = new ArrayList<>();
		results.forEach(returnList::add);

		return returnList;
	}

	@Override
	public List<Long> findAllGlobalLocationIds() {
		return globalLocationRepository.findAllGlobalLocationIds();
	}

	@Override
	public List<String> findAllGlobalLocationNames() {
		return globalLocationRepository.findAllGlobalLocationNames();
	}

	@Override
	public String getLocationNameById(long id) {
		return globalLocationRepository.getLocationNameById(id);
	}

}
