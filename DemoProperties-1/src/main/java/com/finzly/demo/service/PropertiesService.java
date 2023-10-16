package com.finzly.demo.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.finzly.demo.entity.PropertiesManager;
import com.finzly.demo.repository.PropertiesRepository;

@Service
public class PropertiesService {

	@Autowired
	PropertiesRepository propertiesRepository;

	@Autowired
	private ResourceLoader resourceLoader;

	public String readFileFromResources(String fileName) throws IOException {
		Resource resource = resourceLoader.getResource("classpath:" + fileName);

		try (InputStream inputStream = resource.getInputStream(); 
			Scanner scanner = new Scanner(inputStream)) {
			StringBuilder content = new StringBuilder();
			while (scanner.hasNextLine()) {
				content.append(scanner.nextLine()).append("\n");
			}
			seperatorByEquals(content);
			return "Added";
		}catch (Exception e) {
			return " ----------------------"+e.getMessage();
		}
	}

	public void seperatorByEquals(StringBuilder content) {
		String c = content.toString();
		String[] contentsLine = c.split("\n");
		String key;
		String value;

		for (String string : contentsLine) {
			String[] keyValuePair = string.split("=");
			if (keyValuePair.length == 2) {
				key = keyValuePair[0].trim();
				value = keyValuePair[1].trim();
				addingToDataBase(key, value);
			}
		}
	}

	public void addingToDataBase(String key, String value) {
		PropertiesManager p = new PropertiesManager();
		p.setPropertiesKeys(key);
		p.setPropertiesValues(value);
		propertiesRepository.save(p);
	}
}
