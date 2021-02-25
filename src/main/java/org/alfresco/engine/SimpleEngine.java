package org.alfresco.engine;

import static java.util.Arrays.asList;

import java.util.List;

import org.alfresco.bean.Input;
import org.alfresco.bean.Output;

public class SimpleEngine {

	private List<Scheduler> schedulers = asList(
			new SimpleScheduler(),
			new GreedyRoadsScheduler()
	);

	public Output run(Input in, int strategyId) {

		return schedulers.get(strategyId).run(in);

	}

}
