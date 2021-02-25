package org.alfresco.engine;

import org.alfresco.bean.Input;
import org.alfresco.bean.Output;

public class SimpleScheduler implements Scheduler
{
    @Override
    public Output run(Input input)
    {
        return new Output();
    }
}
