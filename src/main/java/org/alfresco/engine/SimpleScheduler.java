package org.alfresco.engine;

import org.alfresco.bean.Input;
import org.alfresco.bean.Output;
import org.alfresco.bean.Street;

public class SimpleScheduler implements Scheduler
{
	
    @Override
    public Output run(Input input)
    {
    	
    	Output output = new Output();
    	
    	for (int i = 0; i < input.getDuration(); i++) {
    	    for (int j = 0; j < input.getCars().size(); j++) {
    	    	String streetName = input.getCars().get(j).getNameOfStreets().get(0);
    	    	Street street = Street.findByStreetName(input.getStreets(), streetName);
    	    }
    	}


        return new Output();
    }
}
