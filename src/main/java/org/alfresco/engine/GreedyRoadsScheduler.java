package org.alfresco.engine;

import java.util.stream.IntStream;

import org.alfresco.bean.Input;
import org.alfresco.bean.Output;

public class GreedyRoadsScheduler implements Scheduler
{
    @Override
    public Output run(Input input)
    {
        Output output = new Output();
        IntStream.range(0, input.getIntersections()).forEach(intersection -> {
            System.out.println("# " + intersection);
            input.getStreets().stream()
                 .filter(street -> street.getEndIntersection() == intersection)
                 .forEach(street -> {
                     System.out.println("##" + street);
                     output.addToCycle(intersection, street, 1);
                 });
        });
        return output;
    }
}
