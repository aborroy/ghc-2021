package org.alfresco.bean;

import java.util.List;

public class Output {
	
	List<Intersection> intersections;

	public List<Intersection> getIntersections() {
		return intersections;
	}

	public void setIntersections(List<Intersection> intersections) {
		this.intersections = intersections;
	}

	@Override
	public String toString() {
		return "Output [intersections=" + intersections + "]";
	}

}
