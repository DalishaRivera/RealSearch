/**
 * 
 */
package interactivegraph;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import interactivegraph.CSVReader;

/**
 * @author Dalisha Rivera
 *
 */

/**
 * Represents an object node for graphviz graph
 */
public class CreateNode { 
	
	public static void main(String[] args) {
		CreateNode.create();
	}
 
	public static void create() {
		
		String fileName = "nodes.dot";
		String[] nodes = CSVReader.nodes();
		System.out.println("READ");
	
		try {
			PrintWriter outputStream = new PrintWriter(fileName);
			
			outputStream.println("strict digraph unix {");
			System.out.println("IT WROTE FIRST LINE!");
			
			outputStream.println("		graph [overlap = false];");
			
			outputStream.println("		node [color = red, style = filled];");
			System.out.println("IT WROTE THE NODE DETAILS!");
			int length = CSVReader.nodes().length;
			System.out.println("LENGTH HERE: " + length);
			for (int i = 1; i < length; i++) {
				System.out.println(i);
				String previous = nodes[i-1];
				String current = nodes[i];
				if (CSVReader.isFirst(i) == true){
					continue;
				}
				if (previous.equalsIgnoreCase(current)) {
					continue;
				}
				else if (current.contains("\"") && previous.contains("\"")) {
					//System.out.println(  "	    " + previous + '"' + " " + "->" + " " + current + '"' + ";");
					outputStream.println("		" + previous + '"' + " " + "->" + " " + current + '"' + ";");
				}
				else if (current.contains("\"") && !(previous.contains("\""))) {	
					//System.out.println(  "		" + '"' + previous + '"' + " " + "->" + " " + current + '"' + ";");
					outputStream.println("		" + '"' + previous + '"' + " " + "->" + " " + current + '"' + ";");
				}
				else if (previous.contains("\"") && !(current.contains("\""))) {
					//System.out.println(  "		" + previous + '"' + " " + "->" + " " + '"' + current + '"' + ";");
					outputStream.println("		" + previous + '"' + " " + "->" + " " + '"' + current + '"' + ";");
				}
				else{
					//System.out.println(  "		" + '"' + previous + '"' + " " + "->" + " " + '"' + current + '"' + ";");
					outputStream.println("		" + '"' + previous + '"' + " " + "->" + " " + '"' + current + '"' + ";");
				}
			}
			
			System.out.println("IT WROTE THE LABELS!");
			
			outputStream.println("}");
			System.out.println("DONE!");
			
			outputStream.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
  }

 }
