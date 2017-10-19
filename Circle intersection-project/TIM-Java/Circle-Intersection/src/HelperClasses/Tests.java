package HelperClasses;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

import Algorithms.Algorithm;
import Algorithms.Circle;
import Algorithms.Data;
import Algorithms.IntersectionDeelTwee;
import Algorithms.RoughAlgo;
import Algorithms.SemiCircle;

public class Tests {
	
	RoughAlgo algo;
	Circle c1;
	Circle c2;
	ArrayList<Circle> list = new ArrayList<>();
	RedBlackBST<Double,Point> bst = new RedBlackBST<Double,Point>();
	SeparateChainingHashST<Double, Double> st=new SeparateChainingHashST<Double, Double>();


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
		assertTrue(algo.getDistanceS(c1,c2)> 28 && algo.getDistanceS(c1,c2) < 28.90);
		
	}
	
	/**
	 * Test to check whether a circle lies inside other or not.
	 */
	@Test
	public void liesInsideOtherCircle(){
		c1 = new Circle(5,0,5);
		c2 = new Circle(5,0,3.8);
		list.add(c1);
		list.add(c2);
		algo = new RoughAlgo(list);
		assertTrue(algo.liesInside(c1, c2));
	}
	
	
	@Test
	public void TestDistance(){
		c1 = new Circle(5,0,5);
		c2 = new Circle(5,-1,3.8);
		Algorithm alg = new RoughAlgo(list);
		assertTrue(alg.getDistanceS(c1, c2)== 1.0);
	}
	
	@Test
	public void TestIntersectionArEdge(){
		c1 = new Circle(1,0,0.5);
		c2 = new Circle(2,0,0.5);
		Algorithm alg = new RoughAlgo(list);
		assertTrue(alg.isIntersectionBetween(c1, c2) == true);
	}
	
	@Test
	public void TestLiesInside(){
		c1 = new Circle(1,0,2);
		c2 = new Circle(1,0,1.9);
		Algorithm alg = new RoughAlgo(list);
		assertTrue(alg.liesInside(c1, c2) == true);
	}
	
	@Test
	public void TestLieOnEachOther(){
		c1 = new Circle(1,0,2);
		c2 = new Circle(1,0,2.0);
		Algorithm alg = new RoughAlgo(list);
		assertTrue(alg.liesOnEachOther(c1, c2) == true);
	}
	
	

/*	SemiCircle dc;
	SemiCircle sc;
	@Test
	public void TestTweeNumberOfIntersections(){
		double x = 0;
		double y = 0;
		double radius = 3;
		double keyFirst = x-radius;
		double keySecond = x+radius;
		SemiCircle second = new SemiCircle(x,y,radius,false,false);
		SemiCircle first = new SemiCircle(x,y,radius,true,false);
		Data data = new Data(keyFirst,x,y,radius,false,false);
		Data dat = new Data(keySecond,x,y,radius,false,false);
		dat.setCircleFirst(first);
		dat.setCircleSecond(second);
		data.setCircleFirst(first);
		data.setCircleSecond(second);
		MinPQ<Data> pq  = new MinPQ<Data>();
		pq.insert(dat);
        pq.insert(data);
    
        double a = 0;
		double b = 1;
		double r = 3;
		double k = a-r;
		double ke = a+r;
		SemiCircle se = new SemiCircle(a,b,r,false,false);
		SemiCircle fi = new SemiCircle(a,b,r,true,false);
		Data da = new Data(k,a,b,r,false,false);
		Data d = new Data(ke,a,b,r,false,false);
		da.setCircleFirst(se);
		da.setCircleSecond(fi);
		d.setCircleFirst(se);
		d.setCircleSecond(fi);
		pq.insert(da);
        pq.insert(d);
		IntersectionDeelTwee twee = new IntersectionDeelTwee(pq);
        int counter =  twee.execute();
        assertTrue(counter == 1);
	}*/

	@Test
	public void TestCeilValueOfRedBlackSearchTree(){
		IntersectionDeelTwee twee = new IntersectionDeelTwee(null);
		RedBlackBST<Double,Data> bt = new RedBlackBST<Double,Data>();
		Data dat = new Data(-1,10,0,1,false,false);
		Data data = new Data(-3,100,4,3,false,false);
		Data da = new Data(2,96,5,2,false,false);
		Data d = new Data(3,101,3,3,false,false);
		MinPQ<Data> pq  = new MinPQ<Data>();
	    bt.put((double) 10,dat);
	    bt.put((double) 100, data);
	    bt.put((double) 96, da);
	    bt.put((double) 101, d);
	    Data dpt = new Data(-1,20,0,1,false,false);
		Data dpa = new Data(-3,30,4,3,false,false);
		Data dm = new Data(2,40,5,2,false,false);
		Data dl = new Data(3,50,3,3,false,false);
        Data d8 = new Data(-50,-50,3,3,false,false);
		Data d7 = new Data(-60,-50,3,3,false,false);
	    bt.put((double) 20,dpt);
	    bt.put((double) 30, dpa);
	    bt.put((double) 40, dm);
	    bt.put((double) 50, dl);
	    bt.put((double) -50,d8);
	    bt.put((double) -60,d7);
	    assertTrue(this.getCeilValue(10, false, bt).getX() == 20);
	}

	

	
	// TODO Here: Getting right ceiling and floor value 
	
	public Data getCeilValue(double key, boolean isUpperCircle, RedBlackBST<Double, Data> bt) {
	      Data circle = bt.ceiling(key);
			return circle;
		}

	
	public Data getFloorValur(double key, boolean isUpperCircle, RedBlackBST<Double, Data> bt) {
	      Data circle = bt.floor(key);
			return circle;
		}

	@Test
  public void testOfHashFunction(){
	SemiCircle second = new SemiCircle(1,2,3,false,false);
	SemiCircle sec = new SemiCircle(1,2,4,false,false);
	SemiCircle first = new SemiCircle(2,2,4,true,false);
	this.st.put(2.1,8.440073165275303 );
	this.st.put(2.1,5.0);
	this.st.put(2.3,6.0);
	Queue<Double> q =st.get(2.1);
	while(!q.isEmpty())
		System.out.println(q.dequeue());
	
//	assertTrue(st.get(2.3)== 6.0);
//	assertTrue(st.get(2.1)== 8.440073165275303);
//	assertTrue(st.get(2.2)== 5.0);
//	assertTrue(st.get(2.3)== 6.0);

	}
	
	
	
	
	
	
	
	
	
	
}
