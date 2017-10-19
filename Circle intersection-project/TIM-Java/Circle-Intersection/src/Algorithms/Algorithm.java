package Algorithms;

public abstract class Algorithm {

	  public double getDistanceS(Circle circle1,Circle circle2) {
			double distance = Math.sqrt((Math.pow(circle2.getX()-circle1.getX(), 2))+ 
		                                     (Math.pow(circle2.getY()-circle1.getY(), 2)));
			return distance;
		}
	  
	  
	  public double getDistance(SemiCircle circle1,SemiCircle circle2) {
			double distance = Math.sqrt((Math.pow(circle2.getxCo()-circle1.getxCo(), 2))+ 
		                                     (Math.pow(circle2.getyCo()-circle1.getyCo(), 2)));
			return distance;
		}
	  
	  
	  
	  public boolean isIntersectionBetween(Circle circle1 , Circle circle2){
		   if(((this.getDistanceS(circle1,circle2)>  circle1.getRadius() + circle2.getRadius())) 
				    || (this.liesInside(circle1, circle2)) ||this.liesOnEachOther(circle1, circle2)){
			  return false;
				    }
		return true;
		   
	   }
	  
	  
	  public boolean isIntersectionBetween(SemiCircle circle1 , SemiCircle circle2){
		   if((this.getDistance(circle1,circle2)>  circle1.getRadius() + circle2.getRadius()) 
				    || (this.liesInside(circle1, circle2))  ||(this.liesOnEachOther(circle1, circle2))){
			  return false;
				    }
		return true;
		   
	   }
	  
	  private boolean liesOnEachOther(SemiCircle circle1, SemiCircle circle2) {
		 return (this.getDistance(circle1,circle2) ==  0) && (circle1.getRadius() == circle2.getRadius());
	}


	public boolean liesInside(SemiCircle circle1,SemiCircle circle2){
		   if(this.getDistance(circle1, circle2) < Math.abs((circle1.getRadius() - circle2.getRadius())))
		       return true;
		return false;
		  
	  }
	  
	  
	  
	  
	  
	  
	  public boolean liesOnEachOther(Circle circle1, Circle circle2) {
		return (this.getDistanceS(circle1,circle2) ==  0) && (circle1.getRadius() == circle2.getRadius());
	}


	public boolean liesInside(Circle circle1,Circle circle2){
		   if(this.getDistanceS(circle1, circle2) < Math.abs((circle1.getRadius() - circle2.getRadius())))
		       return true;
		return false;
		  
	  }

}
