package com.domrade.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.UsStates;
import com.domrade.interfaces.local.UsStatesLocal;
import com.domrade.repository.IUsStatesRepository;

@Service
public class UsStatesService implements UsStatesLocal {

	@Autowired
	private IUsStatesRepository usStates;

	public UsStatesService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<UsStates> findAll() {
		List<UsStates> returnList = new ArrayList<>();
		Iterable<UsStates> iterableStates = usStates.findAll();
		iterableStates.forEach(returnList::add);

		return returnList;
	}

	@Override
	public List<String> findAllStates() {
		return usStates.findAllStates();
	}

	@Override
	public List<Long> findAllStateIds() {
		return usStates.findAllStateIds();
	}

	@Override
	public String getStateNameById(long stateId) {
		return usStates.getStateNameById(stateId);
	}

}
