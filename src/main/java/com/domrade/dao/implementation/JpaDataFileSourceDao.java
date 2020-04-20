package com.domrade.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.dao.JpaDao;
import com.domrade.dao.interfaces.DataFileSourceDao;
import com.domrade.entity.implementation.DataFileSource;

@Service
public class JpaDataFileSourceDao extends JpaDao<Long, DataFileSource> implements DataFileSourceDao {

	public JpaDataFileSourceDao() {
		super(DataFileSource.class);
	}

	@Override
	public List<String> findAllFileNames() {
		List<String> aList = entityManager.createNamedQuery("DataFileSource.findAllFileNames").getResultList();
		return aList;
	}

	@Override
	public String getFileLocation() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public boolean checkForFileInDb(String fileName, String fileLocation) {
		List<String> aList = entityManager.createNamedQuery("DataFileSource.getFileByName")
				.setParameter("param1", fileName).setParameter("param2", fileLocation).getResultList();
		return aList.size() > 0;
	}
}
