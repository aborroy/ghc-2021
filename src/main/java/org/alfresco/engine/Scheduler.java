package org.alfresco.engine;

import org.alfresco.bean.Input;
import org.alfresco.bean.Output;

public interface Scheduler
{
    Output run(Input input);
}
