package org.alfresco.bean;

import java.util.Collection;

public class Intersection {
	
	Integer id;	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public static Intersection findById(Collection<Intersection> intersections, Integer id) {
	    return intersections.stream().filter(intersection -> id == intersection.getId()).findFirst().orElse(null);
	}
	
}
