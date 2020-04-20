package com.domrade.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.dao.interfaces.DataFileSourceDao;
import com.domrade.entity.implementation.DataFileSource;
import com.domrade.interfaces.local.CachedDataLocal;
import com.domrade.interfaces.local.ManageCsvFileServiceLocal;

@Service
public class ManageDataFileService implements ManageCsvFileServiceLocal {

	@Autowired
	private DataFileSourceDao dataFileSourceDao;

	@Autowired
	private CachedDataLocal cachedData;

	public ManageDataFileService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveDataFile(String fileLocation, String fileName) {
		DataFileSource dataFileSource = new DataFileSource();
		dataFileSource.setFileLocation(fileLocation);
		dataFileSource.setFileName(fileName);
		dataFileSource.setId(new Long((fileLocation + fileName).hashCode()));
		dataFileSourceDao.persist(dataFileSource);
	}

	@Override
	public void setCachedFileNames() {
		cachedData.setAllFileNames(dataFileSourceDao.findAllFileNames());
	}

	@Override
	public boolean checkForFileInDb(String fileName, String fileLocation) {
		return dataFileSourceDao.checkForFileInDb(fileName, fileLocation);
	}

	@Override
	public void saveFileToDisk(Part uploadedFile, String fileLocation, String fileName) {
		try (InputStream input = uploadedFile.getInputStream()) {
			Files.copy(input, new File(fileLocation, fileName).toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
