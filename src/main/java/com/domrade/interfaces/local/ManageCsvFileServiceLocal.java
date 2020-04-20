package com.domrade.interfaces.local;

import javax.servlet.http.Part;

import org.springframework.stereotype.Service;

@Service
public interface ManageCsvFileServiceLocal {

	public void saveDataFile(String fileLocation, String fileName);

	public void setCachedFileNames();

	public boolean checkForFileInDb(String fileName, String fileLocation);

	public void saveFileToDisk(Part uploadedFile, String fileLocation, String fileName);
}
