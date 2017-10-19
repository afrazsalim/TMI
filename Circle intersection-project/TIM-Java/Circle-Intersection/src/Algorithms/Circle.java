package Algorithms;

public class Circle implements Comparable<Circle> {
	private double x;
	private double y;
	private double radius;
	double maxX = 0;
	double maxY = 0;
	double minX = 0;
	double minY = 0;
	private double UpperY;

	Intersections[] intersect = new Intersections[100];
	int index = 0;
	private boolean isUpperCircle;
	private boolean isDownCircle;

	/**
	 * Constructor for a circle
	 * @param x
	 *    The x-coordinate of a circle
	 * @param y
	 *    The y-coordinate of a circle
	 * @param radius
	 *    Radius of a circle
	 * @param b 
	 */
	public Circle(double x, double y ,double radius){
		this.x = x;
		this.y = y;
		this.radius = radius;

	}
	
	
	
	/**
	 * 
	 * @return the X-coordinate of the circle
	 */
	public double getX(){
		return this.x;
	}

	/**
	 * 
	 * @return
	 *      Returns the y-coordinate of a circle
	 */
	public double getY(){
		return this.y;
	}
	
	
	
	/**
	 * 
	 * @return 
	 *     Returns the radius of a circle.
	 */
	public double getRadius(){
		return this.radius;
	}

	
	 public boolean equals(Circle circle2) {
	      if(this.getX() == circle2.getX() && this.getY() == circle2.getY() && this.getRadius() == circle2.getRadius())
	    	  return true;
		   return false;
		}
	 
	 
	 public double getLeftX(){
		 return this.getX()- (this.getRadius());
	 }
	 
	 public double getRightX(){
		 return this.getX()+ this.getRadius();
	 }



	public double getUpperKey() {
		return this.getLeftY()-1000;
	}

	public double getDownKey() {
		return this.getLeftY()+1000;
	}


	private double getLeftY() {
		return this.getY()-this.getRadius();
	}



	@Override
	public int compareTo(Circle c) {
		return Double.compare(this.getLeftX(), c.getLeftX());
	}



	public Double getUPerY() {		
		return this.getY()-this.getRadius();
	}

	
	public Double getDownY() {		
		return this.getY()+this.getRadius();
	}


	 
}
