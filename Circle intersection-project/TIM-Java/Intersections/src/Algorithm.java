
public abstract class Algorithm {

	  protected double getDistance(Circle circle1,Circle circle2) {
			double distance = Math.sqrt((Math.pow(circle2.getX()-circle1.getX(), 2))+ 
		                                     (Math.pow(circle2.getY()-circle1.getY(), 2)));
			return distance;
		}
}
