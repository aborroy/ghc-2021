package org.alfresco.engine;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import org.alfresco.bean.Car;
import org.alfresco.bean.Input;
import org.alfresco.bean.Output;
import org.alfresco.bean.Street;

public class PrioritiseRoadsByCars implements Scheduler
{
    @Override
    public Output run(Input input)
    {
        Output output = new Output();

        // Sort the streets by the number of times a car takes each.
        Multiset<String> drivenOnCount = HashMultiset.create();
        input.getCars().stream().map(Car::getStreets).forEach(streetList -> streetList.stream().map(Street::getName).forEach(drivenOnCount::add));

        IntStream.range(0, input.getIntersections()).forEach(intersection -> {
            input.getStreets().stream()
                 .filter(street -> street.getEndIntersection() == intersection)
                 .filter(street -> input.getCars().stream().anyMatch(car -> car.getNameOfStreets().contains(street.getName())))
                 .forEach(street -> {
                     output.addToCycle(intersection, street, drivenOnCount.count(street.getName()));
                 });
        });

        System.out.println(output);
        return output;
    }
}
