package org.alfresco.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

		Map<String, Street> streetMap = new HashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			int lineCount = 0;
			for (String line; (line = br.readLine()) != null;) {
				String[] numbers = line.split(" ");
				if (lineCount == 0) {
					input.setDuration(Integer.valueOf(numbers[0]));
					input.setIntersections(Integer.valueOf(numbers[1]));
					input.setStreetsNumber(Integer.valueOf(numbers[2]));
					input.setCarsNumber(Integer.valueOf(numbers[3]));
					input.setBonusPoints(Integer.valueOf(numbers[4]));
				}
				else if (lineCount < input.getStreetsNumber() + 1) {
					Street street = new Street();
					street.setStartIntersection(Integer.valueOf(numbers[0]));
					street.setEndIntersection(Integer.valueOf(numbers[1]));
					street.setName(numbers[2]);
					street.setTime(Integer.valueOf(numbers[3]));
					input.getStreets().add(street);

					streetMap.put(street.getName(), street);
				}
				else {
					Car car = new Car();
					car.setNumberOfStreets(Integer.valueOf(numbers[0]));
					String[] subarray = new String[numbers.length -1];
			        System.arraycopy(numbers, 1, subarray, 0, numbers.length - 1);
					car.setNameOfStreets(Arrays.asList(subarray));
					// This works because all the streets are listed in the input before all the cars.
					car.setStreets(getStreetsFromNames(streetMap, car.getNameOfStreets()));
			        input.getCars().add(car);
				}
				lineCount++;
			}
		}
		return input;
	}

	private static List<Street> getStreetsFromNames(Map<String, Street> streetMap, List<String> nameOfStreets)
	{
		return nameOfStreets.stream().map(name -> streetMap.get(name)).collect(Collectors.toList());
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
			Map<Integer, LinkedHashMap<String, Integer>> schedule = output.getSchedule();
			writer.write(schedule.size() + "\n");
			schedule.entrySet().forEach(entry ->{
				try {
					writer.write(entry.getKey() + "\n");
					writer.write(entry.getValue().size() + "\n");
					entry.getValue().forEach((street, duration) -> {
						try {
							writer.write(street + " " + duration + "\n");
						} catch (IOException e) {
							e.printStackTrace();
						}
					});
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		}
	}

}