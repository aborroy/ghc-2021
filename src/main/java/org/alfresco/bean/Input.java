package org.alfresco.bean;

import java.util.List;

public class Input {
	
	Integer duration;
	Integer intersections;
	Integer streetsNumber;
	Integer carsNumber;
	Integer bonusPoints;
	
	List<Street> streets;
	List<Car> cars;
	
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Integer getIntersections() {
		return intersections;
	}
	public void setIntersections(Integer intersections) {
		this.intersections = intersections;
	}
	public Integer getStreetsNumber() {
		return streetsNumber;
	}
	public void setStreetsNumber(Integer streetsNumber) {
		this.streetsNumber = streetsNumber;
	}
	public Integer getCarsNumber() {
		return carsNumber;
	}
	public void setCarsNumber(Integer carsNumber) {
		this.carsNumber = carsNumber;
	}
	public Integer getBonusPoints() {
		return bonusPoints;
	}
	public void setBonusPoints(Integer bonusPoints) {
		this.bonusPoints = bonusPoints;
	}
	public List<Street> getStreets() {
		return streets;
	}
	public void setStreets(List<Street> streets) {
		this.streets = streets;
	}
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	@Override
	public String toString() {
		return "Input [duration=" + duration + ", intersections=" + intersections + ", streetsNumber=" + streetsNumber
				+ ", carsNumber=" + carsNumber + ", bonusPoints=" + bonusPoints + ", streets=" + streets + ", cars="
				+ cars + "]";
	}

}
