package Algorithms;

public class Point implements Comparable<Point> {

	private double point;
	private Circle circle;

	public Point(double d, Circle circle) {
		this.setPoint(d);
		this.setCircle(circle);
	}

	
	public boolean isLeftX(){
		return this.getPoint() == this.getCircle().getLeftX();
	}
	
	
	public boolean isRightX(){
		return this.getPoint() == this.getCircle().getRightX();
	}
	
	@Override
	public int compareTo(Point c) {
		return Double.compare(this.getPoint(), c.getPoint());
	}



	public Circle getCircle() {
		return circle;
	}


	public void setCircle(Circle circle) {
		this.circle = circle;
	}


	public double getPoint() {
		return point;
	}


	public void setPoint(double point) {
		this.point = point;
	}

}
