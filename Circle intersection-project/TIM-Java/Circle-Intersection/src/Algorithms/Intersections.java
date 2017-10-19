package Algorithms;
public class Intersections {

	private Circle circle1;
	private Circle circle2;
	private double IntersectionPoint;
	private boolean isFirstIP;
	private boolean isUpperCircle;

	public Intersections(double intersectionPoint, Circle circle, Circle circle2,boolean isFirstIntersectionPoint, boolean isUpperCircle) {
          this.setCircle1(circle);
          this.setCircle2(circle2);
          this.setIntersectionPoint(intersectionPoint);
          this.setFirstIP(isFirstIntersectionPoint);
          this.setUpperCircle(isUpperCircle);
	}

	
	
	
	private void setIntersectionPoint(double intersectionPoint) {
        this.IntersectionPoint = intersectionPoint;		
	}

	public double getIntersectionP(){
		return this.IntersectionPoint;
	}

	public Circle getCircle2() {
		return this.circle2;
	}

	public void setCircle2(Circle circle2) {
		this.circle2 = circle2;
	}

	public Circle getCircle1() {
		return this.circle1;
	}

	public void setCircle1(Circle circle1) {
		this.circle1 = circle1;
	}




	public boolean isUpperCircle() {
		return isUpperCircle;
	}




	public void setUpperCircle(boolean isUpperCircle) {
		this.isUpperCircle = isUpperCircle;
	}




	public boolean isFirstIP() {
		return isFirstIP;
	}




	public void setFirstIP(boolean isFirstIP) {
		this.isFirstIP = isFirstIP;
	}

}
