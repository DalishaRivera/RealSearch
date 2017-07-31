package interactivegraph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class NodeFocus {
	
	public static void Focus(String node) {
		
		BufferedReader br = null;
		
		try {
			PrintWriter outputStream = new PrintWriter("focused.dot");
			outputStream.println("strict digraph unix {");
			outputStream.println("		graph [overlap = false];");
			outputStream.println("		node [color = red, style = filled];");
			
			System.out.println("GRAPH AND NODE DETAILS DONE WRITING!");
			
			br = new BufferedReader(new FileReader("nodes.dot"));
			
			System.out.println("BUFFERED READER DONE!!");
			String line = "";
			//int acc = 1;
			while ((line = br.readLine()) != null) { //to determine what the size array needs to be
				//System.out.println(acc);
				//acc++;
				if (line.contains(node)){
					System.out.println(line);
					outputStream.println(line);
				}
			}
			
			System.out.println("WHILE LOOP DONE!!");
			
			outputStream.println("}");
			outputStream.close();
			
			System.out.println("DONE");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog(null, "Which binary would you like to focus on?");
		
		NodeFocus.Focus(input);
		
	}

}
