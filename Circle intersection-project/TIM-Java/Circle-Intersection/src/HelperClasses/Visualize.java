package HelperClasses;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Algorithms.Circle;
import Algorithms.IntersectionAlgo;

public class Visualize extends JPanel {
	 private ArrayList<Circle> list;

	public Visualize(ArrayList<Circle> list,IntersectionAlgo window){
		 this.list = list;
		 JFrame f = new JFrame();
	     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     f.setSize(1400, 1200);
	     f.setVisible(true);
	     f.setLocationRelativeTo(null);
	    
	  
	 }
     

}
