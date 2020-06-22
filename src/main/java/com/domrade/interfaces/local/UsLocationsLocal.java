package com.domrade.interfaces.local;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.UsLocations;

@Service
public interface UsLocationsLocal {

	public List<UsLocations> findAll();

	public String getCountyNameByLocationId(long id);

	public List<Long> getCountiesByStateId(long stateId);

	public ArrayList<String> getCountyNamesByStateId(long stateId);

	public List<Long> getUsLocationIds();

}
