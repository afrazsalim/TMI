package Algorithms;

public class SemiCircle {

	private double xCo;
	private double yCo;
	private double radius;
	private boolean isUpperCircle;
	private double setKey;
	private boolean isIntersectionPoint;
	private SemiCircle part;

	public SemiCircle(double x, double y, double radius, boolean b,boolean isIntersectionPoint) {
		this.setxCo(x);
		this.setyCo(y);
		this.setRadius(radius);
		this.setUpperCircle(b);
		this.setIntersectionPoint(isIntersectionPoint);
	}


	
	public void setKey(double d) {
     this.setKey = d;		
	}
	public double getKey(){
		return this.setKey;
	}

	public boolean isUpperCircle() {
		return isUpperCircle;
	}

	public void setUpperCircle(boolean isUpperCircle) {
		this.isUpperCircle = isUpperCircle;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getyCo() {
		return yCo;
	}

	public void setyCo(double yCo) {
		this.yCo = yCo;
	}

	public double getxCo() {
		return xCo;
	}

	public void setxCo(double xCo) {
		this.xCo = xCo;
	}


	public boolean isIntersectionPoint() {
		return isIntersectionPoint;
	}


	public void setIntersectionPoint(boolean isIntersectionPoint) {
		this.isIntersectionPoint = isIntersectionPoint;
	}

	@Override
	public boolean equals(Object second){
		if( this.getyCo() == ((SemiCircle) second).getyCo()  && this.getRadius() == ((SemiCircle) second).getRadius())
			return true;
		return false;
	}
	
	public double getRightX(){
		return this.getxCo()+this.getRadius();
	}



	public void setSecondPart(SemiCircle first) {
      this.part	 = first;
	}
	
	public SemiCircle getPart(){
		return this.part;
	}
}
