
public class Point {
	private double point;
	private Circle c;

	public Point(Circle c ,double point){
		this.c = c;
		this.point = point;
	}
	
 protected Circle getOwner(){
	 return this.c;
 }
 
 protected double getPoint(){
	 return this.point;
 }

}
