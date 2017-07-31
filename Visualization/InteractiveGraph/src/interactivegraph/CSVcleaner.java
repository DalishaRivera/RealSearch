package interactivegraph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import interactivegraph.CSVReader;

public class CSVcleaner extends CSVReader {
	
	public static void main(String[] args) {
		CSVcleaner.clean();
		CSVcleaner.cleanAgain();
	}

	public static void clean() {
		File inputFile = new File("2000_subset.csv");
		//System.out.println("OG FILE READ");
		File tempFile = new File("myTempFile.csv");
		//System.out.println("TEMP FILE READ");

		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		String csvSplitBy = ","; //comma separated
		
		try {
			reader = new BufferedReader(new FileReader(inputFile));
			writer = new BufferedWriter(new FileWriter(tempFile));
			
			String lineToRemove = "Build id: ";
			int length = CSVReader.length("2000_subset.csv");
			String temp = "";
			for (int i = 0; i <= length; i++) {
				String currentLine = reader.readLine();
				//System.out.println(currentLine);
				String[] curr = currentLine.split(csvSplitBy);
				String[] prev = temp.split(csvSplitBy);
				if (currentLine.contains(lineToRemove)) {
					writer.write(prev[0] + "," + prev[1] + "," + prev[2] + "," + prev[3] + "," + curr[4].trim() + "," + curr[5] );
				}
				else {
					//System.out.println(currentLine);
					writer.write(currentLine);
				}
				writer.newLine();
				temp = currentLine;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void cleanAgain() {
		File inputFile = new File("myTempFile.csv");
		//System.out.println("OG FILE READ");
		File tempFile = new File("cleanFile.csv");
		//System.out.println("TEMP FILE READ");

		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			reader = new BufferedReader(new FileReader(inputFile));
			writer = new BufferedWriter(new FileWriter(tempFile));
			
			//int length = CSVReader.length("myTempFile.csv");
			String csvSplitBy = ","; //comma separated
			String temp = reader.readLine();
			String currentLine = reader.readLine();
			//System.out.println(length);
			while ((temp != null) && (currentLine != null)) {
				String[] curr = currentLine.split(csvSplitBy);
				String[] prev = temp.split(csvSplitBy);
				if (curr[0].equals(prev[0]) && curr[1].equals(prev[1]) && currentLine.contains(temp)) {
					writer.write(currentLine);
					//System.out.println("IF   " + currentLine);
				}
				else {
					writer.write(temp);
					writer.newLine();
					writer.write(currentLine);
					//System.out.println("ELSE   " + temp);
					//System.out.println("ELSE   " + currentLine);
				}
				temp = reader.readLine();
				currentLine = reader.readLine();
				writer.newLine();
			}
			//System.out.print("LAST   " + temp);
			writer.write(temp);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
