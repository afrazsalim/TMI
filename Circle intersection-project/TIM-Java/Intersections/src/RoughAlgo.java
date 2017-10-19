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
			for( int j = i+1;j < list.size();j++){
				if(this.isIntersectionBetween(list.get(i),list.get(j))){
					this.counter++;
			    if(!(list.get(i).equals(list.get(j))))
					points = p.calculateThePoints(list.get(i),list.get(j),this);
				}
				
			}
		}
		points.add(counter);
		return points;
	}

	
	
  

protected boolean isIntersectionBetween(Circle circle1 , Circle circle2){
	   if((this.getDistance(circle1,circle2)< circle1.getRadius() + circle2.getRadius()) 
			    &&(!this.liesInside(circle1, circle2)))
		  return true;
	   else if((this.getDistance(circle1,circle2) ==  0) && (circle1.getRadius() == circle2.getRadius()))
		  return true;
	return false;
	   
   }

  
  protected boolean liesInside(Circle circle1,Circle circle2){
	   if(this.getDistance(circle1, circle2) < Math.abs((circle1.getRadius() - circle2.getRadius())))
	       return true;
	return false;
	  
  }
}
