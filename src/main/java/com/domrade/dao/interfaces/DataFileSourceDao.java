package com.domrade.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.DataFileSource;

@Service
public interface DataFileSourceDao extends Dao<Long, DataFileSource> {

	public List<String> findAllFileNames();

	public String getFileLocation();

	public boolean checkForFileInDb(String fileName, String fileLocation);

}
