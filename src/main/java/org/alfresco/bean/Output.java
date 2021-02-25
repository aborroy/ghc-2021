package org.alfresco.bean;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Output {
    Map<Integer, LinkedHashMap<String, Integer>> schedule = new HashMap<>();
	
	public Map<Integer, LinkedHashMap<String, Integer>> getSchedule() {
		return schedule;
	}

	public void addToCycle(Intersection intersection, Street street, int duration) {
	    if (!schedule.containsKey(intersection.id)) {
	        schedule.put(intersection.id, new LinkedHashMap<>());
        }
		schedule.get(intersection.id).put(street.name, duration);
	}

	@Override
	public String toString() {
		return "Output [schedule=" + schedule + "]";
	}

}
