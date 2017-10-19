package HelperClasses;

import Algorithms.SemiCircle;

public class CircleCover {

	private SemiCircle second;
	private SemiCircle first;
	private double point;

	public CircleCover(double point,SemiCircle first, SemiCircle second) {
      this.setFirst(first);
      this.setSecond(second);
      this.setPoint(point);	
	}

	public SemiCircle getFirst() {
		return first;
	}

	public void setFirst(SemiCircle first) {
		this.first = first;
	}

	public SemiCircle getSecond() {
		return second;
	}

	public void setSecond(SemiCircle second) {
		this.second = second;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

}
