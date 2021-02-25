package org.alfresco.main;

import java.io.File;

import org.alfresco.bean.Input;
import org.alfresco.bean.Output;
import org.alfresco.engine.SimpleEngine;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.SimpleCommandLinePropertySource;

/**
 * Main class to be launched from command line
 * 
 * java -jar target/hashcode-2020-1.0.0.jar
 * --fileIn=src/main/resources/in/a_example.in
 * --fileOut=src/main/resources/in/a_example.out
 * --strategy=0
 * 
 * Available strategies:
 * - 0: ...
 * - 1: ...
 * 
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

	private SimpleEngine simpleEngine = new SimpleEngine();

	private String defaultFile = "a.txt";
	private String defaultStrategy = "2";
	private String defaultFileOut = "a.txt";

	@Override
	public void run(String... args) throws Exception {

		PropertySource<?> ps = new SimpleCommandLinePropertySource(args);
		Object fileIn = ps.getProperty("fileIn");
		if (fileIn == null) {
			fileIn = new File(defaultFile);
		}
		File inFile = new File("in/" + fileIn.toString());
		Input in = Translator.getInput(inFile);
		
		Object strategy = ps.getProperty("strategy");
		if (strategy == null) {
			strategy = defaultStrategy;
		}
		Integer strategyNumber = Integer.valueOf(strategy.toString());
		Output out = simpleEngine.run(in, strategyNumber);

		Object fileOut = ps.getProperty("fileOut");
		if (fileOut == null) {
			fileOut = defaultFileOut;
		}
		File outFile = new File("out/" + fileOut.toString());
		Translator.writeOutput(out, outFile);

	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
