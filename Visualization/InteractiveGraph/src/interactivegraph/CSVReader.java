package interactivegraph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Dalisha Rivera
 *
 */

public class CSVReader {
	static String csvFile = "C:/Users/Dalisha/Visualization/InteractiveGraph/cleanFile.csv"; //path to .csv file
	static int length  = CSVReader.length(csvFile);
	static String[] nodes = new String[length]; //declare array length 
	
	public static void main(String[] args) {
		CSVReader.nodes(); //calling to get a string array of binary nodes
	} 
	
	public static Boolean isFirst(int n) { //boolean to determine if frame number is 1
		
		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ","; //comma separated
		String framenum = null;
		
		try{

			br = new BufferedReader(new FileReader(csvFile));
			br.readLine();
			
			for (int i = 0; i <= n; i++){ //going to line n and declaring its frame number
				line = br.readLine();
				String[] frame = line.split(csvSplitBy);
				framenum = frame[1];
			}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		if (framenum == "1") {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public static int length (String csv) {
		String csvFile = csv;
		BufferedReader br = null;
		int acc = 0; //accumulator for array length
		
		try {
			br = new BufferedReader(new FileReader(csvFile));
			br.readLine();
			while ((br.readLine()) != null) { //to determine what the size array needs to be
				acc++;
				//System.out.println(acc);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("LENGTH IS HERE!!!!!!!" + acc);
		
		return acc;
	}

	public static String[] nodes() {
		
		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ","; //comma separated
		
		try{

			br = new BufferedReader(new FileReader(csvFile));
			br.readLine();
			//System.out.println(length);
			for (int i = 0; i < length; i++){ 
				//System.out.println(i);
				//System.out.println(line); 
				// use comma as separator
				line = br.readLine().toString();
				//System.out.println(line);
				String[] binary = line.split(csvSplitBy);
				//System.out.println("Binary: " + binary[3]);
				nodes[i] = binary[3];
				//System.out.println(node);
				
				//System.out.println(nodes[i]);
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return nodes;
		
	}

}
