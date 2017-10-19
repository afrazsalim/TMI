import java.util.ArrayList;

public class Points {

	public  ArrayList<Double> calculateThePoints(Circle circle, Circle circle2, Algorithm algo) {
        ArrayList<Double> points = new ArrayList<>();
		double distance = algo.getDistance(circle,circle2);
       double lengthOfIntersection = (Math.pow(circle.getRadius(), 2) - Math.pow(circle2.getRadius(), 2) + Math.pow(distance, 2))/(2*distance);
       double perpendicular = Math.pow(circle.getRadius(),2) - Math.pow(lengthOfIntersection, 2);
	   double midX = circle.getX()+ lengthOfIntersection*(circle2.getX()-circle.getX())/(distance);
	   double midY = circle.getY()+ lengthOfIntersection*(circle2.getY()-circle.getY())/(distance);
	   double intersectionXup = midX + perpendicular*(circle2.getY() - circle.getY());
	   double intersectionXdown = midX - perpendicular*(circle2.getY() - circle.getY());
	   double intersectionYup = midY + perpendicular*(circle2.getX() - circle.getX());
	   double intersectionYdown = midY - perpendicular*(circle2.getX() - circle.getX());
	   points.add(intersectionXup);
	   points.add(intersectionYup);
	   points.add(intersectionXdown);
	   points.add(intersectionYdown);
	return points;
	}

}
