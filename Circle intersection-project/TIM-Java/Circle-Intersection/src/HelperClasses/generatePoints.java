package HelperClasses;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class generatePoints {

	public void writeOutPoints() {
		Random r = new Random();
		ArrayList<Double> list = new ArrayList<>();
		JOptionPane.showMessageDialog(null, "Select a file to save intersection points\n" + "or select an alreay created file");
		BufferedWriter writer = null;
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
		  File file = fileChooser.getSelectedFile();
		  try {
			writer = new BufferedWriter(new FileWriter(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		  try {
			  for(int i = 0; i< 50000;i++){
				  double x =  0.0 + (50 - 0) * r.nextDouble();
				  double y =  i;
				  double radius =  0.0 + (1000 - 0) * r.nextDouble();
				  writer.append( x + "  " + y + "  "+ radius +"\n");
			  }
		} catch (IOException e2) {
			e2.printStackTrace();
		}
			  finally {
		            try {
		                writer.flush();
		            } catch (Exception e) {
		            	
		            }
		         }
		  }
 
        JOptionPane.showMessageDialog(null, "Co-ordinates are written to the selected file");
	}	
	


	public static void main(String [] args){
		generatePoints point = new generatePoints();
		point.writeOutPoints();
	}
}
