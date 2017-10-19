package HelperClasses;

public class IntersectionData {

	private double firstKey;
	private double secondKey;
	private double secondPoint;
	private double intersectionPoint;

	public IntersectionData(double firstKey) {
	this.setFirstKey(firstKey);
	}

	public double getFirstKey() {
		return firstKey;
	}

	public void setFirstKey(double firstKey) {
		this.firstKey = firstKey;
	}

	public double getSecondKey() {
		return secondKey;
	}

	public void setSecondKey(double secondKey) {
		this.secondKey = secondKey;
	}

	public double getSecondPoint() {
		return secondPoint;
	}

	public void setSecondPoint(double secondPoint) {
		this.secondPoint = secondPoint;
	}

	public double getIntersectionPoint() {
		return intersectionPoint;
	}

	public void setIntersectionPoint(double intersectionPoint) {
		this.intersectionPoint = intersectionPoint;
	}
}
