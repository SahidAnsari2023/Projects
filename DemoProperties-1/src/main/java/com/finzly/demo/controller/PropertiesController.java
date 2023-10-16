package com.finzly.demo.controller;

import java.io.IOException; 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.finzly.demo.entity.PropertiesManager;
import com.finzly.demo.service.PropertiesService;

@RestController
public class PropertiesController {

	@Autowired
	Environment env;
	@Autowired
	PropertiesManager propertiesManager;
	@Autowired
	PropertiesService propertiesService;
	
	
//	@RunWith(SpringRunner.class)
//	@TestPropertySource("/foo.properties")
	
	@RequestMapping(method = RequestMethod.GET,value = "/getallfromprop")
	public String readPropertiesFile() throws IOException {
		String filename = "application.properties";
		return propertiesService.readFileFromResources(filename);
	}
	
	
	
	
	

//	@GetMapping("/fname")
//	public String getName1() {
//		return env.getProperty("first.name");
//	}
//
//	@GetMapping("/lname")
//	public String getName2() {
//		return env.getProperty("last.name");
//	}
//
//	@RequestMapping(method = RequestMethod.POST, value = "/fname/{name}")
//	public String setFirstName(@PathVariable String name) {
//		propertiesManager.setFirstName(env.getProperty("first.name"));
//		return "Added FName to Pojo";
//	}
//
//	@RequestMapping("/lname/{name}")
//	public String setLasttName(@PathVariable String name) {
//		propertiesManager.setLastName(env.getProperty("last.name"));
//		return "Added LName to Pojo";
//	}
//
//	@RequestMapping("/all")
//	public void getAll() {
//		//return propertiesService.getAll();
//		
//
//	}

}
