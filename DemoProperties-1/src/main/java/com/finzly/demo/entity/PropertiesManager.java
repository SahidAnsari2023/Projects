package com.finzly.demo.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "properties_manager")
public class PropertiesManager {
	
	
	private long id1;
	private String propertiesKeys;
	private String propertiesValues;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId1() {
		return id1;
	}
	public void setId1(long id1) {
		this.id1 = id1;
	}
	public String getPropertiesKeys() {
		return propertiesKeys;
	}
	public void setPropertiesKeys(String propertiesKeys) {
		this.propertiesKeys = propertiesKeys;
	}
	public String getPropertiesValues() {
		return propertiesValues;
	}
	public void setPropertiesValues(String propertiesValues) {
		this.propertiesValues = propertiesValues;
	}
	
	
	
}
