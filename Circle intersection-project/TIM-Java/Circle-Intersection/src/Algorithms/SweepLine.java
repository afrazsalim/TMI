package Algorithms;

import java.util.ArrayList;

import HelperClasses.MinPQ;
import HelperClasses.Queue;
import HelperClasses.RangeSearch;

public class SweepLine extends Algorithm{
	RangeSearch<Double,Circle> r ;
	Queue<Circle> q;
	Points point ;
	ArrayList<Double> list;
	private double count;
	public SweepLine(){
		r = new RangeSearch<Double ,Circle>();
		q  = new Queue<Circle>();
		point = new Points();
		list = new ArrayList<Double>();
		this.count = 0;
	}

	public ArrayList<Double> execute(MinPQ<Point> pq) {
       while(!pq.isEmpty()){
    	   Point p = pq.delMin();
    	   if(p.isLeftX()){
    		   r.put(p.getCircle().getUPerY(), p.getCircle(),p.getCircle().getDownY());
    	   }
    	   else if(p.isRightX()){
    		   q = r.doRangeSearch(p.getCircle(),p.getCircle().getUPerY());
    		   while(!q.isEmpty()){
    			   this.setCounter(this.getCounter()+1);
    			   list = point.calculateThePoints(q.dequeue(),p.getCircle());
    		   }
   			r.delete(p.getCircle().getUPerY());
    	   }
       }
       list.add(this.getCounter());
	return list;
	}

	private void setCounter(double i) {
       this.count = i;		
	}

	private double getCounter() {
		return this.count;
	}
	

}

