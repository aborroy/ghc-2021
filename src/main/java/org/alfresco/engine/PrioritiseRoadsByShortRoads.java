package org.alfresco.engine;

import java.util.Comparator;
import java.util.stream.IntStream;

import org.alfresco.bean.Input;
import org.alfresco.bean.Output;

public class PrioritiseRoadsByShortRoads implements Scheduler {
	@Override
	public Output run(Input input) {
		Output output = new Output();

		// Sort the streets by their duration.
		input.getStreets().sort(Comparator.comparingInt(street -> -street.getTime()));

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
