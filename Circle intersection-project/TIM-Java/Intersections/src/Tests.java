import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Tests {
	
	RoughAlgo algo;
	Circle c1;
	Circle c2;
	ArrayList<Circle> list = new ArrayList<>();

	/**
	 * Test  to determine whether the distance formula is correct or no.
	 * Due to the floating point, i had to use bounds otherwise i needed to type in all
	 * leading values after the point.
	 */
	@Test
	public void test() {
		c1 = new Circle(10,20,5);
		c2 = new Circle(30,40,3.8);
		list.add(c1);
		list.add(c2);
		algo = new RoughAlgo(list);
		assertTrue(algo.getDistance(c1,c2)> 28 && algo.getDistance(c1,c2) < 28.90);
		
	}
	
	/**
	 * Test to check whether a circle lies inside other or not.
	 */
	@Test
	public void liesInsideOtherCircle(){
		c1 = new Circle(5,0,5);
		c2 = new Circle(5,-1.2,3.8);
		list.add(c1);
		list.add(c2);
		algo = new RoughAlgo(list);
		assertTrue(algo.liesInside(c1, c2));
		
		
	}
}
