package com.finzly.demo.controller;

import java.io.IOException; 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.finzly.demo.entity.PropertiesManager;
import com.finzly.demo.service.PropertiesService;

import jakarta.annotation.PostConstruct;

@RestController
public class PropertiesController {

	@Autowired
	Environment env;
	@Autowired
	PropertiesManager propertiesManager;
	@Autowired
	PropertiesService propertiesService;
	
	@PostConstruct
	@RequestMapping(method = RequestMethod.GET,value = "/getallfromprop/{filename}")
	public String readPropertiesFile() throws IOException {
		return propertiesService.readFileFromResources(filename);
	}
	

}
