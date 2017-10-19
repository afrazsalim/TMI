package HelperClasses;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class InputFrame {
	public InputFrame(){
		  
	    }
	
	protected File getFile(){
		 JFileChooser chooser = new JFileChooser();
	        FileNameExtensionFilter filter = new FileNameExtensionFilter(
	                ".txt", "txt");
	        File file = null;
	        chooser.setFileFilter(filter);
	        int returnVal = chooser.showOpenDialog(null);
	        if(returnVal == JFileChooser.APPROVE_OPTION) {
	            file = chooser.getSelectedFile();
				Scanner in = null;
				try {
					in = new Scanner(file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
	        }
			return file;
	}
}
