package org.alfresco.bean;

import java.util.Collection;

public class Street {
	// Use objects here, but primitives in the getters/setters to ensure these aren't null after initialisation.
	Integer startIntersection;
	Integer endIntersection;
	String name;
	Integer time;

	public int getStartIntersection() {
		return startIntersection;
	}
	public void setStartIntersection(int startIntersections) {
		this.startIntersection = startIntersections;
	}
	public int getEndIntersection() {
		return endIntersection;
	}
	public void setEndIntersection(int endIntersections) {
		this.endIntersection = endIntersections;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Street [startIntersections=" + startIntersection + ", endIntersections=" + endIntersection + ", name="
				+ name + ", time=" + time + "]";
	}
	
	public static Street findByStreetName(Collection<Street> streets, String name) {
	    return streets.stream().filter(street -> name.equals(street.getName())).findFirst().orElse(null);
	}

}
