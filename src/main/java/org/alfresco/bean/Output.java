package org.alfresco.bean;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Output {
    Map<Integer, LinkedHashMap<String, Integer>> schedule = new HashMap<>();
	
	public Map<Integer, LinkedHashMap<String, Integer>> getSchedule() {
		return schedule;
	}

    /**
     * Add an instruction for a set of traffic lights.
     * @param intersection The id of the intersection with the traffic lights.
     * @param street The street leading to the intersection.
     * @param duration The duration to turn on the lights for.
     */
	public void addToCycle(int intersection, Street street, int duration) {
	    if (!schedule.containsKey(intersection)) {
	        schedule.put(intersection, new LinkedHashMap<>());
        }
		schedule.get(intersection).put(street.name, duration);
	}

	@Override
	public String toString() {
		return "Output [schedule=" + schedule + "]";
	}

}
