package org.alfresco.bean;

import java.util.List;

public class Car {

	Integer numberOfStreets;
	List<String> nameOfStreets;
	
	public Integer getNumberOfStreets() {
		return numberOfStreets;
	}
	public void setNumberOfStreets(Integer numberOfStreets) {
		this.numberOfStreets = numberOfStreets;
	}
	public List<String> getNameOfStreets() {
		return nameOfStreets;
	}
	public void setNameOfStreets(List<String> nameOfStreets) {
		this.nameOfStreets = nameOfStreets;
	}
}
