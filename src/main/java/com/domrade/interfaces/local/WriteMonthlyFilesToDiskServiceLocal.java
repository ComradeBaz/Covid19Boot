/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.interfaces.local;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 *
 * @author David
 */
@Service
public interface WriteMonthlyFilesToDiskServiceLocal {

	public void writeFileToDisk(String fileName, List<String> dataToWrite);

}
