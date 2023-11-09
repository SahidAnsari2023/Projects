package com.finzly.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.demo.dao.PropertiesDao;
import com.finzly.demo.entity.PropertiesManager;

@Service
public class PropertiesService {

	@Autowired
	PropertiesDao propertiesDao;
	PropertiesManager propertiesManager;

	public List<PropertiesManager> getNameFromTable() {
		System.out.println("IN SERVICE");
		return propertiesDao.getNameFromTable();
	}

	public String setNameFromPropeties(PropertiesManager pm) {
		System.out.println("In service");
		return propertiesDao.setNameFromPropeties(pm);
	}

	public String setNameFromAPI(PropertiesManager propertiesManager2) {
		
		return propertiesDao.setNameFromAPI(propertiesManager2);
	}

}
