package org.alfresco.bean;

import java.util.Collection;

public class Street {
	
	Integer startIntersection;
	Integer endIntersection;
	String name;
	Integer time;
	
	public Integer getStartIntersection() {
		return startIntersection;
	}
	public void setStartIntersection(Integer startIntersections) {
		this.startIntersection = startIntersections;
	}
	public Integer getEndIntersection() {
		return endIntersection;
	}
	public void setEndIntersection(Integer endIntersections) {
		this.endIntersection = endIntersections;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
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
