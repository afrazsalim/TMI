import java.awt.Component;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class IntersectionAlgo {
	 
	public static void main(String [] args){
		ArrayList<Circle> list = new ArrayList<>();
		
		int numberOfIntersections = 0;
		double radius;
		double y;
		double x;
		Scanner in = null;
    	try {
			 in = new Scanner(new File("src/file.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("First coordinate is expected to be x and second y and third radius");
		int choiceOfAlgorithm = in.nextInt();
		int size = in.nextInt();
		Point [] array = new Point[size*2];
		for(int i = 0; i < size; i++){
			  x = in.nextDouble();
			  y = in.nextDouble();
			 radius = in.nextDouble();
			Circle circle = new Circle(x,y,radius);
			list.add(circle);
		}
		int index = 0;
		if(choiceOfAlgorithm == 1){
		RoughAlgo algo = new RoughAlgo(list);
	    ArrayList<Double> points = algo.execute();
	    double numberOfIntersection = points.get(0);
	    System.out.println("Number of Intersections " + numberOfIntersection );
	    for(int i = 1; i < points.size();i++){
	    	System.out.println("Co-ordinates are " + points.get(i));
		     }
		}
		else if(choiceOfAlgorithm == 2){
			for(int i = 0; i< list.size();i++){
				Point Leftp = new Point(list.get(i),list.get(i).getLeftX());
				Point Rightp = new Point(list.get(i),list.get(i).getRightX());
		    	array[index++] = Leftp;
		    	array[index++] = Rightp;
			}
			for(int i = 0; i < array.length;i++)
				System.out.println(array[i].getPoint() + "before sorting");
			Quick sort = new Quick(array);
			sort.sort(array);
			BST t = new BST();
		}
		
			EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	            	new Visualize(list);
	            }
	        });
			
			
			
         }
	}




