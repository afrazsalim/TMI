package Algorithms;
import java.util.ArrayList;

public class Points extends Algorithm {
	  ArrayList<Double> points;
	  double [] arr;
	  double [] akr;
	  int index = 0;
	  int index2= 0;
	public Points(){
		points = new ArrayList<>();
		arr = new double[100];
		akr = new double[100];
		
	 }

	
	 public double getDistanceS(Circle circle1,Circle circle2) {
			double distance = Math.sqrt((Math.pow(circle2.getX()-circle1.getX(), 2))+ 
		                                     (Math.pow(circle2.getY()-circle1.getY(), 2)));
			
			return distance;
		}
	  
	public  ArrayList<Double> calculateThePoints(Circle circle, Circle circle2) {
       double distance = this.getDistanceS(circle,circle2);
       double lengthOfIntersection = (Math.pow(circle.getRadius(), 2) - Math.pow(circle2.getRadius(), 2) + Math.pow(distance, 2))/(2*distance);
       double perpendicular = Math.sqrt(Math.pow(circle.getRadius(),2) - Math.pow(lengthOfIntersection, 2));
       double midX = circle.getX()+ (lengthOfIntersection*(circle2.getX()-circle.getX())/(distance));
	   double midY = circle.getY()+ (lengthOfIntersection*(circle2.getY()-circle.getY())/(distance));	   
	   double intersectionXup = midX + perpendicular*(circle2.getY() - circle.getY())/distance;
	   double intersectionXdown = midX - perpendicular*(circle2.getY() - circle.getY())/distance;
	   double intersectionYup = midY + perpendicular*(circle2.getX() - circle.getX())/distance;
	   double intersectionYdown = midY - perpendicular*(circle2.getX() - circle.getX())/distance;
	   points.add(intersectionYup);
	   points.add(intersectionXup);
	   points.add(intersectionYdown);
	   points.add(intersectionXdown);
	   
	return points;
	}
	
	

	
	public  ArrayList<Double> calculatePoints(SemiCircle circle, SemiCircle circle2) {
		   ArrayList<Double> list = new ArrayList<Double>();
	       double distance = this.getDistance(circle,circle2);
	       double lengthOfIntersection = (Math.pow(circle.getRadius(), 2) - Math.pow(circle2.getRadius(), 2) + Math.pow(distance, 2))/(2*distance);
	       double perpendicular =Math.sqrt( Math.pow(circle.getRadius(),2) - Math.pow(lengthOfIntersection, 2));
		   double midX = circle.getxCo()+ lengthOfIntersection*(circle2.getxCo()-circle.getxCo())/(distance);
		   double midY = circle.getyCo()+ lengthOfIntersection*(circle2.getyCo()-circle.getyCo())/(distance);
		   double intersectionXup = midX + perpendicular*(circle2.getyCo() - circle.getyCo())/distance;
		   double intersectionXdown = midX - perpendicular*(circle2.getyCo() - circle.getyCo())/distance;
		   double intersectionYup = midY + perpendicular*(circle2.getxCo() - circle.getxCo())/distance;
		   double intersectionYdown = midY - perpendicular*(circle2.getxCo() - circle.getxCo())/distance;
		   list.add(intersectionXup);
		   list.add(intersectionYup);
		   list.add(intersectionXdown);
		   list.add(intersectionYdown);
		return list;
		}
		
	
	
	
	
	
	
	
	
	
	


}
