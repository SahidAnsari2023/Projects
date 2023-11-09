package com.finzly.demo.controller;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	

	
	
	@GetMapping("/user")
	public String login() {
		return "User Sahid";
	}
	
	@GetMapping("/getname")
	public List<PropertiesManager> getNameFromTable() {
		return propertiesService.getNameFromTable();
		//return env.getProperty("first.name");
	}

	@GetMapping("/allfromproperties")
	public String getAll() {
		return (env.getProperty("first.name")+" "+env.getProperty("last.name"));

	}
	
	@PostMapping("/set")
	public String setNameFromPropeties() {
		PropertiesManager pm = new PropertiesManager();
		pm.setFirstName(env.getProperty("first.name"));
		pm.setLastName(env.getProperty("last.name"));
		return propertiesService.setNameFromPropeties(pm);
	}
	
	@PostMapping("/setall")
	public String setNameFromAPI(@RequestBody PropertiesManager propertiesManager) {
//		PropertiesManager pm = new PropertiesManager();
//		pm.setFirstName(env.getProperty("first.name"));
//		pm.setLastName(env.getProperty("last.name"));
		return propertiesService.setNameFromAPI(propertiesManager);
	}
	
	
//	@GetMapping("/lname")
//	public String getLastNameFromApp() {
//		return env.getProperty("last.name");
//	}
	

//	@RequestMapping(method = RequestMethod.POST, value = "/fname/{name}")
//	public String setFirstName(@PathVariable String name) {
//		propertiesManager.setFirstName(env.getProperty("first.name"));
//		return "Added FName to Pojo";
//	}

	
//	@RequestMapping(method = RequestMethod.POST, value = "/lname/{name}")
//	public String setLasttName(@PathVariable String name) {
//		propertiesManager.setLastName(env.getProperty("last.name"));
//		return "Added LName to Pojo";
//	}

}
