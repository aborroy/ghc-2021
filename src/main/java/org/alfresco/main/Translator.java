package org.alfresco.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import org.alfresco.bean.Car;
import org.alfresco.bean.Input;
import org.alfresco.bean.Output;
import org.alfresco.bean.Street;

/**
 * Translate files into beans and reverse.
 */
public class Translator {

	/**
	 * Get Input Bean from input file
	 * 
	 * @param file Input file from statement
	 * @return Input Bean with the values from the input file
	 * @throws Exception When reading the file fails
	 */
	public static Input getInput(File file) throws Exception {
		Input input = new Input();
		input.setStreets(new ArrayList<Street>());
		input.setCars(new ArrayList<Car>());
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			int lineCount = 0;
			for (String line; (line = br.readLine()) != null;) {
				String[] numbers = line.split(" ");
				System.out.println("Line count: " + lineCount + ", numbers: " + numbers);
				if (lineCount == 0) {
					input.setDuration(Integer.valueOf(numbers[0]));
					input.setIntersections(Integer.valueOf(numbers[1]));
					input.setStreetsNumber(Integer.valueOf(numbers[2]));
					input.setCarsNumber(Integer.valueOf(numbers[3]));
					input.setBonusPoints(Integer.valueOf(numbers[4]));
				}
				else if (lineCount < input.getStreetsNumber()) {
					Street street = new Street();
					street.setStartIntersections(Integer.valueOf(numbers[0]));
					street.setEndIntersections(Integer.valueOf(numbers[1]));
					street.setName(numbers[2]);
					street.setTime(Integer.valueOf(numbers[3]));
					input.getStreets().add(street);
				}
				else {
					Car car = new Car();
					car.setNumberOfStreets(Integer.valueOf(numbers[0]));
				}
				lineCount++;
			}
		}
		return input;
	}
	
	/**
	 * Get Output File from Output Bean
	 * 
	 * @param output  Output Bean with the values for the file
	 * @param outFile Output file path to write in
	 * @throws Exception When writing the file fails
	 */
	public static void writeOutput(Output output, File outFile) throws Exception {

		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)))) {
			writer.write("0\n");
		}
	}

}