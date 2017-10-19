
public class Circle {
	private double x;
	private double y;
	private double radius;
	double maxX = 0;
	double maxY = 0;
	double minX = 0;
	double minY = 0;

	/**
	 * Constructor for a circle
	 * @param x
	 *    The x-coordinate of a circle
	 * @param y
	 *    The y-coordinate of a circle
	 * @param radius
	 *    Radius of a circle
	 */
	protected Circle(double x, double y ,double radius ){
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

	public void setMaxCo(double x, double y) {
		if(this.maxX < x)
			this.maxX = x;
		else if(this.minX  > x)
		this.minX = x;
		 if(this.maxY < y)
			 this.maxY = y;
		 else if(this.minY > y)
			 this.minY = y;
       		
	}
	
	public double getMaxX(){
		return this.maxX;
	}
	
	
	public double getMinX(){
		return this.minX;
	}
	
	public double getMaxY(){
		return this.maxY;
	}
	
	public double getMinY(){
		return this.minY;
	}
	
	
	 public boolean equals(Circle circle2) {
	      if(this.getX() == circle2.getX() && this.getY() == circle2.getY() && this.getRadius() == circle2.getRadius())
	    	  return true;
		   return false;
		}
	 
	 
	 protected double getLeftX(){
		 return this.getX()- (this.getRadius());
	 }
	 
	 protected double getRightX(){
		 return this.getX()+ this.getRadius();
	 }
	 
}
