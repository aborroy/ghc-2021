package org.alfresco.engine;

import org.alfresco.bean.Input;
import org.alfresco.bean.Output;

public class SimpleEngine {

	public enum Strategy {
		SIMPLE, 
		COMPLEX
	}

	public Output run(Input in, Strategy strategy) {

		Output out = new Output();
		
		// Loop is happening...

		return out;
		
	}

}
