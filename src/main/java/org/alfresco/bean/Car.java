package org.alfresco.bean;

import java.util.List;

public class Car {

	Integer numberOfStreets;
	List<String> nameOfStreets;
	private List<Street> streets;

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

	public List<Street> getStreets() {
		return streets;
	}

	public void setStreets(List<Street> streets) {
		this.streets = streets;
	}

	@Override
	public String toString() {
		return "Car [numberOfStreets=" + numberOfStreets + ", nameOfStreets=" + nameOfStreets + "]";
	}
}
