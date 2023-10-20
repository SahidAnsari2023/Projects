package com.finzly.demo.service;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.*;
import java.util.Map.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.finzly.demo.entity.PropertiesManager;
import com.finzly.demo.repository.PropertiesRepository;

@Service
public class PropertiesService {

	@Autowired
	PropertiesRepository propertiesRepository;


//	@Autowired
//	private ResourceLoader resourceLoader;
	
	private Map<String , String> mappedKeyValue = new HashMap<>();

	public Map<String, String> readFileFromResources(String fileName) {
//		Resource resource = resourceLoader.getResource("classpath:" + fileName);
//		Properties properties = new Properties();
			
		try {
			BufferedInputStream bis = new BufferedInputStream(new ClassPathResource(fileName).getInputStream());
			int characterInBis;			
			StringBuilder currentLine = new StringBuilder();

            while ((characterInBis = bis.read()) != -1) {
                char currentChar = (char) characterInBis;
                if (currentChar == '\n') {
                    String[] keyValue = currentLine.toString().split("=");
                    if (keyValue.length == 2) {
                        String key = keyValue[0];
                        String value = keyValue[1];
                        System.out.println("Key: " + key + "\nValue: " + value);
                        mappedKeyValue.put(key, value);
                    }
                    currentLine.setLength(0); // Clear the current line buffer
                } else {
                    currentLine.append(currentChar);
                }
            }
			
//          Method 1
//			StringBuilder sb = new StringBuilder();
//			while((characterInBis = bis.read()) != -1) {
//				sb.append((char) characterInBis);
//			}
//						
//			for(String line: sb.toString().split("\n")){
//				String[] keyValue = line.split("=");
//				if(keyValue.length == 2) {
//					String key = keyValue[0];
//					String value = keyValue[1];
////					System.out.println("Key: "+key+"\nValue: "+value);
//					mappedKeyValue.put(key, value);
//				}
//			}
			
//          Method 2
//			InputStream is = res.getInputStream();
//			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//			
//			String line;
//			while((line = reader.readLine()) != null){
//				String[] content = line.split("=");
//				if(content.length == 2) {
//					String key = content[0];
//					String value = content[1];
//					mappedKeyValue.put(key, value);
//				}
//			}
			
			
//          Method 3
//			InputStream inputStream = resource.getInputStream();
//			properties.load(inputStream);
//			System.out.println(inputStream);
//			
//			for (String name : properties.stringPropertyNames()) {
//				String value = properties.getProperty(name);				
//				mappedKeyValue.put(name, value);				
//			}
			
			
			return addingToDataBase(mappedKeyValue);
		}catch (Exception e) {
			return null;
		}
	}
	
	
	public Map<String, String> addingToDataBase(Map<String, String> mappedKeyValue) {
		for (Entry<String, String> entry : mappedKeyValue.entrySet()) {
			PropertiesManager p = new PropertiesManager();
			p.setPropertiesKeys(entry.getKey());
			p.setPropertiesValues(entry.getValue());
			propertiesRepository.save(p);
	    }
		return mappedKeyValue;
		
	}
	

}
