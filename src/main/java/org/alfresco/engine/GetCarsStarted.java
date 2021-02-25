package org.alfresco.engine;

import java.util.Comparator;
import java.util.stream.IntStream;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import org.alfresco.bean.Car;
import org.alfresco.bean.Input;
import org.alfresco.bean.Output;

public class GetCarsStarted implements Scheduler {
	@Override
	public Output run(Input input) {
		Output output = new Output();

		// Find the streets with the most cars waiting to start.
		Multiset<String> waitingToStartCount = HashMultiset.create();
		input.getCars().stream().map(Car::getStreets).forEach(streetList -> waitingToStartCount.add(streetList.get(0).getName()));

		// Sort the streets by their initial popularity.
		input.getStreets().sort(Comparator.comparingInt(street -> waitingToStartCount.count(street.getName())));

		IntStream.range(0, input.getIntersections()).forEach(intersection -> {
			input.getStreets().stream()
				 .filter(street -> street.getEndIntersection() == intersection)
				 .filter(street -> input.getCars().stream().anyMatch(car -> car.getNameOfStreets().contains(street.getName())))
				 .forEach(street -> {
				 	int duration = (waitingToStartCount.count(street.getName()) > 1 ? 1 : 1);
				 	output.addToCycle(intersection, street, duration);
				 });
		});

		System.out.println(output);
		return output;
	}
}
