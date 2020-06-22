package com.domrade.interfaces.local;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.UsStates;

@Service
public interface UsStatesLocal {

	public List<UsStates> findAll();

	public List<String> findAllStates();

	public List<Long> findAllStateIds();

	public String getStateNameById(long stateId);

}
