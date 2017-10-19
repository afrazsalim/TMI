package Algorithms;
import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import HelperClasses.FrameClass;
import HelperClasses.FrameComp;
import HelperClasses.MinPQ;
import HelperClasses.Stopwatch;

public class IntersectionAlgo  {
	private Thread thread;
	private boolean running = false;
	ArrayList<Circle> list;
	private IntersectionAlgo v;
	private File file;
	private int setAlgorithmType;
	private FrameClass setFrameClass;
	Stopwatch timer2;
	Stopwatch tim;
	MinPQ<Data> pq  = new MinPQ();
	MinPQ<Point> pq3;
	public IntersectionAlgo(){
		list = new ArrayList<Circle>();
		FrameClass frame= new FrameClass(this);
		this.setFrameClass(frame);
		frame.execute();
		Scanner in = null;
		int d = 0;
		File file = null;
	    while(file == null){
           file = this.getFile();
           System.out.println("");
	     }
	    
			if (!file.canRead()) {
             JOptionPane.showMessageDialog(null, "File could not be read");
				return;   
			}
			try {
				in = new Scanner(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("executing 2nd");
			int choice = (int) in.nextDouble();
			int size = (int) in.nextDouble();
			System.out.println("exe"+ size+ " ch" + choice);
			System.out.println(choice + "choice");
			if(choice == 1){
				for(int i = 0; i < size;i++){
					double x = in.nextDouble();
					double y = in.nextDouble();
					double radius = in.nextDouble();
						Circle circle = new Circle(x,y,radius);
						list.add(circle);
					}
	            JOptionPane.showMessageDialog(null,"Points are being calculated it takes time , please wait");
				this.execute(list);
				}
			else if(choice == 3){
				pq3  = new MinPQ<Point>();
				for(int i = 0; i < size;i++){
					double x = in.nextDouble();
					double y = in.nextDouble();
					double radius = in.nextDouble();
					Circle circle = new Circle(x,y,radius);
					Point p  = new Point(x-radius,circle);
					Point p2  = new Point(x+radius,circle);
					pq3.insert(p);
					pq3.insert(p2);
	      	}
            JOptionPane.showMessageDialog(null,"Points are being calculated it takes time , please wait");
				this.executeSecond(pq3);
		}
			else if(choice == 2){
	            JOptionPane.showMessageDialog(null,"Points are being calculated it takes time , please wait");
				this.executeThird(size,in);
			}
	   }
	 
	 
	private void executeSecond(MinPQ<Point> pq32) {
		SweepLine alg = new SweepLine();
		Stopwatch  tim = new Stopwatch();
		ArrayList<Double > list = alg.execute(pq32);
		double time = tim.elapsedTime();
		System.out.println("Time taken by this algorithm is : " + time);
		this.WriteToScreen(list.get(list.size()-1), list,time);
	}


	private void executeThird(int size, Scanner in) {
        for(int i = 0; i < size;i++){
        	double x = in.nextDouble();
			double y = in.nextDouble();
			double radius = in.nextDouble();
			double keyFirst = x-radius;
			double keySecond = x+radius;
			SemiCircle second = new SemiCircle(x,y,radius,false,false);
			SemiCircle first = new SemiCircle(x,y,radius,true,false);
			Data data = new Data(keyFirst,x,y,radius,false,false);
			Data dat = new Data(keySecond,x,y,radius,false,false);
			dat.setCircleFirst(first);
			dat.setCircleSecond(second);
			data.setCircleFirst(first);
			data.setCircleSecond(second);
			first.setSecondPart(second);
			second.setSecondPart(first);
        	pq.insert(data);
        	pq.insert(dat);
        }
        IntersectionDeelTwee inter = new IntersectionDeelTwee(pq);
		 tim = new Stopwatch();
        ArrayList<Double> intersections = inter.execute();
        double time = tim.elapsedTime();
		System.out.println(time + "   time elapsed ");
		for(int i = 0;  i< intersections.size();i++)
		System.out.println("Intersections  " + intersections.get(i));
		this.WriteToScreen(intersections.get(intersections.size()-1), intersections,time);
	}

	


	

	private void WriteToScreen(double numberOfIntersection,ArrayList<Double> points, double time) {
		 //   FrameComp f = new FrameComp();
		  //  Frame frame = f.getFrame();
		   // JTextArea field = new JTextArea();
		    //field.setEditable(false);
		    //f.addFieldToFrame(field,frame);		
		    //field.append("Number of intersections " + numberOfIntersection + "\n");
		   // for(int i = 0; i < points.size()-1;i = i+2){
		    //	field.append(("    " + points.get(i) +  "                " + points.get(i+1)+ "\n"));
			  // }
		    this.getFrame().writeOutPoints(points,time);
	}


	private void setFrameClass(FrameClass frame) {
           this.setFrameClass = frame;		
	}

	
	private FrameClass getFrame(){
		return this.setFrameClass;
	}

	private void execute(ArrayList<Circle> list) {
		RoughAlgo algo = new RoughAlgo(list);
		timer2 = new Stopwatch();
	    ArrayList<Double> points = algo.execute();
	    double time =  timer2.elapsedTime();
	    double numberOfIntersection = points.get(points.size()-1);
	   this.WriteToScreen(numberOfIntersection,points,time);
		System.out.println("%e (%.2f seconds)\n  and the time " +time + "Number of intersections " +numberOfIntersection );
	}


	public static void main(String [] args){
		ArrayList<Circle> list = new ArrayList<>();
		IntersectionAlgo inter = new IntersectionAlgo();
	}
	
	
	
	
	public void setFile(File file) {
		System.out.println("setFile" + file);
         this.file = file;		
	}
	
	protected File getFile(){
		return this.file;
	}


	public void setAlgorithmType(int i) {
      this.setAlgorithmType = i;		
	}
	
	
	protected int getAlgorithmType(){
		return this.setAlgorithmType;
	}
	
	
}




