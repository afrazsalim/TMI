package Algorithms;

import java.util.Random;

public class Data implements  Comparable<Data> {

	private double Key;
	private double x;
	private double y;
	private double radius;
	private SemiCircle firstCircle;
	private SemiCircle secondCircle;
	private boolean isIntersectionP;
	private double setSecondKey;
	private double firstkey;
	private boolean isSecondInterPoint;
	private SemiCircle firstC;
	private SemiCircle secondC;

	public Data(double Key, double x, double y, double radius,boolean isIntersectionPoint, boolean isSecond) {
		this.setKeyFirst(Key);
		if(!isIntersectionPoint){
		this.setX(x);
		this.setY(y);
		this.setRadius(radius);	
		this.setSecondInterPoint(isSecond);
		}
		this.setIntersectionP(isIntersectionPoint);
		if(isIntersectionPoint){
			this.firstkey(y);
			this.setSecondKey(x);
		}
	}

	
	public void setCircleFirstInter(SemiCircle c){
		this.firstC = c;
	}
	
	public void setCircleSecondInter(SemiCircle c){
		this.secondC = c;
	}
	
	public SemiCircle getCircleSecondInter(){
		return this.secondC;
	}
	
	public SemiCircle getCircleFirstInter(){
		return this.firstC;
	}


	public double getFirstKey(){
		return this.firstkey;
	}
	
	
	private void firstkey(double y2) {
      this.firstkey = y2;		
	}



	private void setSecondKey(double x2) {
    this.setSecondKey = x2;		
	}

	public double getSecondKey(){
		return this.setSecondKey;
	}


	public void setCircleSecond(SemiCircle second) {
		this.secondCircle = second;
		this.getDown().setKey(this.getY()+100000);
		System.out.println("Key set " +this.getDown().getKey());
	}

	
	public SemiCircle GetUpper(){
		return this.firstCircle;
	}

	
	
	public SemiCircle getDown(){
		return this.secondCircle;
	}

	public void setCircleFirst(SemiCircle first) {
		   this.firstCircle = first;
		   this.GetUpper().setKey(this.getY()-100000);
		   System.out.println("Key set " +this.GetUpper().getKey());
	}



	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getKeyFirst() {
		return Key;
	}

	public void setKeyFirst(double keyFirst) {
		this.Key = keyFirst;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}
	
	
	public boolean isLeftXco(double point){
		return point == this.getX()-this.getRadius() && !this.isIntersectionP();
	}
	
	public boolean isRightXco(double point){
		return point == this.getX()+ this.getRadius() && !this.isIntersectionP();
	}

	@Override
	public int compareTo(Data data) {
		return Double.compare(this.getKeyFirst(), data.getKeyFirst());
	}



	public boolean isIntersectionP() {
		return isIntersectionP;
	}



	public void setIntersectionP(boolean isIntersectionP) {
		this.isIntersectionP = isIntersectionP;
	}

	public boolean isSecondInterPoint() {
		return isSecondInterPoint;
	}

	public void setSecondInterPoint(boolean isSecondInterPoint) {
		this.isSecondInterPoint = isSecondInterPoint;
	}


	
	

}
