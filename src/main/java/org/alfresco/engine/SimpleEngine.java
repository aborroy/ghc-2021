package org.alfresco.engine;

import static org.alfresco.engine.SimpleEngine.Strategy.SIMPLE;

import java.util.HashMap;
import java.util.Map;

import org.alfresco.bean.Input;
import org.alfresco.bean.Output;

public class SimpleEngine {

	public enum Strategy {
		SIMPLE, 
		COMPLEX
	}

	private Map<Strategy, Scheduler> schedulers = new HashMap<>();

	public SimpleEngine() {
		schedulers.put(SIMPLE, new SimpleScheduler());
	}

	public Output run(Input in, Strategy strategy) {

		return schedulers.get(strategy).run(in);

	}

}
