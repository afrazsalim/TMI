package Algorithms;
import java.util.ArrayList;


public class RoughAlgo extends Algorithm {
	private double counter;
	private ArrayList<Circle> list;

	public RoughAlgo(ArrayList<Circle> list){
		this.list = list;
	}
	
	protected ArrayList<Double> execute(){
		this.counter = 0;
		ArrayList<Double> points = new ArrayList<>();
		Points p = new Points();
		
		for(int i = 0; i < list.size();i++){
			for( int j = i+1;j  < list.size();j++){
				if(this.isIntersectionBetween(list.get(i),list.get(j))){
					this.counter = counter+1;
					System.out.println(list.get(i).getX() + " " + list.get(j).getX() + "  " + list.get(i).getRadius());
			    if(!(this.liesOnEachOther(this.list.get(i), this.list.get(j))) && (this.isIntersectionBetween(list.get(i), list.get(j)))){
			    	points = p.calculateThePoints(list.get(i),list.get(j));
			    	System.out.println("counter  " + counter);
			          
			         }
				}
				
			}
		}
        points.add(counter);
		return points;
	}

	
	
  



  

}
