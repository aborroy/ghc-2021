package org.alfresco.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;

import org.alfresco.bean.Input;
import org.alfresco.bean.Output;

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
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			int lineCount = 0;
			for (String line; (line = br.readLine()) != null;) {
				int[] numbers = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
				System.out.println("Line count: " + lineCount + ", numbers: " + numbers);
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