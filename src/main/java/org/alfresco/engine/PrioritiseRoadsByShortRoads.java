package org.alfresco.engine;

import java.util.Comparator;
import java.util.stream.IntStream;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import org.alfresco.bean.Input;
import org.alfresco.bean.Output;
import org.alfresco.bean.Street;

public class PrioritiseRoadsByShortRoads implements Scheduler {
	@Override
	public Output run(Input input) {
		Output output = new Output();

		// Sort the streets by their duration.
		Multiset<String> drivenOnCount = HashMultiset.create();
		input.getStreets().sort(Comparator.comparing(Street::getTime));

		IntStream.range(0, input.getIntersections()).forEach(intersection -> {
			input.getStreets().stream()
				 .filter(street -> street.getEndIntersection() == intersection)
				 .filter(street -> input.getCars().stream().anyMatch(car -> car.getNameOfStreets().contains(street.getName())))
				 .forEach(street -> {
					 output.addToCycle(intersection, street, 1);
				 });
		});

		System.out.println(output);
		return output;
	}
}
