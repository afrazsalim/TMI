package Algorithms;
import java.util.ArrayList;

import HelperClasses.IntersectionData;
import HelperClasses.MinPQ;
import HelperClasses.Queue;
import HelperClasses.RedBlackBST;
import HelperClasses.SeparateChainingHashST;
import HelperClasses.Stopwatch;

public class IntersectionDeelTwee extends Algorithm {

	private MinPQ<Data> pq;
	RedBlackBST<Double ,SemiCircle> bst;
	Points points;
	double counter;
	int index1;
	int index2;
	int index3;
	double [] first = new double[10000000];
	double [] second = new double[10000000];
	double [] intersection = new double[10000000];
	int [] intersectIonPoints = new int[100000];
	double [] circleTest = new double[100000];
	double [] circleTes = new double[100000];
	int [] interp = new int[100000];
	int [] check = new int[100000];
	ArrayList<Double> intersect;
	double time = 0;
	SeparateChainingHashST<Double, IntersectionData> stt = new SeparateChainingHashST<Double, IntersectionData>();

	public IntersectionDeelTwee(MinPQ<Data> pq2) {
	   bst = new RedBlackBST<Double,SemiCircle>();
       this.pq = pq2;
       points = new Points();
       intersect = new ArrayList<Double>();
	}

	public ArrayList<Double> execute() {
     while(!pq.isEmpty()){
    	 Data data = pq.delMin();
    	 if(data.isLeftXco(data.getKeyFirst())){
    		 bst.put(data.GetUpper().getKey(), data.GetUpper());
    		 SemiCircle ceil = this.getCeilValue(data.GetUpper().getKey(),data.GetUpper().isUpperCircle(),data);
       		 if(ceil != null){
    		   this.checkForIntersection(data.GetUpper(),ceil,pq,true,data.getKeyFirst());
       		 }
       	 	SemiCircle floor = this.getFloorValue(data.GetUpper().getKey(),data.GetUpper().isUpperCircle(),data);
    		 if(floor != null)
    			 this.checkForIntersection(data.GetUpper(),floor,pq,true,data.getKeyFirst());
    		 bst.put(data.getDown().getKey(), data.getDown());
    		 SemiCircle ceilSecond = this.getCeilValue(data.getDown().getKey(),data.getDown().isUpperCircle(),data);
    		 if(ceilSecond != null )
    			 this.checkForIntersection(data.getDown(),ceilSecond,pq,false,data.getKeyFirst());
    		 SemiCircle floorSecond =  this.getFloorValue(data.getDown().getKey(),data.getDown().isUpperCircle(),data);
    		 if(floorSecond != null )
    			 this.checkForIntersection(data.getDown(),floorSecond,pq,false,data.getKeyFirst());
    	 }
    	 else if(data.isRightXco(data.getKeyFirst())){
    		 SemiCircle floorValue = this.getFloorValue(data.GetUpper().getKey(),data.GetUpper().isUpperCircle(),data);
    		 SemiCircle ceilValue = this.getCeilValue(data.GetUpper().getKey(),data.GetUpper().isUpperCircle(),data);
    		 if(floorValue != null && ceilValue != null){
    		 this.checkForIntersection(floorValue, ceilValue, pq, floorValue.isUpperCircle(),data.getKeyFirst());
    		 }
    		  bst.delete(data.GetUpper().getKey() );
    		 SemiCircle floorValueS = this.getFloorValue(data.getDown().getKey(),data.getDown().isUpperCircle(),data);
    		 SemiCircle ceilValueS = this.getCeilValue(data.getDown().getKey(),data.getDown().isUpperCircle(),data);
    		 if(floorValueS != null && ceilValueS != null){
    		 this.checkForIntersection(floorValueS, ceilValueS, pq, floorValueS.isUpperCircle(),data.getKeyFirst());
    		 }
    		 bst.delete(data.getDown().getKey());
           
    	 }
    	 else if(data.isIntersectionP()){
    		 this.incrementCounter(counter,data.getKeyFirst());
    		 SemiCircle firstCircle = data.getCircleFirstInter();
    		 SemiCircle secondCircle = data.getCircleSecondInter();
    		 double firstKey = firstCircle.getKey();
    		 double secondKey = secondCircle.getKey();
    		 bst.delete(firstKey);
    		 bst.delete(secondKey);
    		 firstCircle.setKey(secondKey);
    		 secondCircle.setKey(firstKey);
    		 bst.put(firstCircle.getKey(), firstCircle);
    		 SemiCircle Upper = bst.ceiling(firstCircle.getKey());
    		    this.checkForIntersection(firstCircle, Upper, pq, firstCircle.isUpperCircle(),data.getKeyFirst());
    		 SemiCircle Down = bst.floor(firstCircle.getKey());
    	    	 this.checkForIntersection(firstCircle, Down, pq, firstCircle.isUpperCircle(),data.getKeyFirst());
    		   bst.put(secondCircle.getKey(), secondCircle);
    		 SemiCircle UpperS = bst.ceiling(secondCircle.getKey());
    		 this.checkForIntersection(UpperS,secondCircle, pq, secondCircle.isUpperCircle(),data.getKeyFirst());
    		 SemiCircle DownS = bst.floor(secondCircle.getKey());
    		 this.checkForIntersection(secondCircle, DownS, pq, secondCircle.isUpperCircle(),data.getKeyFirst());
    	 }
     }
     this.intersect.add(counter/2);
	return this.intersect;
}


	

	private SemiCircle getFloorValue(double key, boolean isUpperCircle, Data data) {
		SemiCircle circle = bst.floor(key);
	      if(circle != null && !data.isIntersectionP() && isUpperCircle  && this.areEqual(circle, data.GetUpper()))
	    	  circle = bst.floor(circle.getKey());
	      else if(circle != null && !data.isIntersectionP() && !isUpperCircle && this.areEqual(circle, data.getDown()))
	    	  circle = bst.floor(circle.getKey());
			return circle;
	}

	public SemiCircle getCeilValue(double key, boolean isUpperCircle, Data data) {
      SemiCircle circle = bst.ceiling(key);
      if(circle != null && !data.isIntersectionP() && isUpperCircle  && this.areEqual(circle,data.GetUpper()))
    	  circle = bst.ceiling(circle.getKey());
      else if(circle != null && !data.isIntersectionP() && !isUpperCircle && this.areEqual(circle,data.getDown()))
    	  circle = bst.ceiling(circle.getKey());
		return circle;
	}
	
	
	

	private boolean areEqual(SemiCircle circle, SemiCircle getUpper) {
		return (circle.getRadius() == getUpper.getRadius() && getUpper.getyCo() == circle.getyCo() && getUpper.getxCo() == circle.getxCo());
		}

	private void incrementCounter(double counter2, double point) {
			this.setCounter(this.getCounter()+1);
	}

	private void setCounter(double d) {
      this.counter = d;		
	}

	private double getCounter() {
		return this.counter;
	}

	private void checkForIntersection(SemiCircle getUpper, SemiCircle ceil, MinPQ<Data> pq, boolean isUpper,double point) {
		if(getUpper == null || ceil == null || this.areEqual(getUpper, ceil))
			return;
		Stopwatch watch = new Stopwatch();
		if(this.areChecked(getUpper,ceil)){
			this.time = this.time+watch.elapsedTime();
			return;
		}
		ArrayList<Double> list = new ArrayList<>();
	if(this.isIntersectionBetween(getUpper, ceil)){
		list = points.calculatePoints(getUpper, ceil);
		    this.intersect.addAll(list);
			double FirstIntersectionP = list.get(0);
			double secondIntersection = 0;
			Data dat = null;
			Data data = new Data(FirstIntersectionP,ceil.getKey(),getUpper.getKey(),0,true,false);
			data.setCircleFirstInter(ceil);
			data.setCircleSecondInter(getUpper);
			if(list.size() > 3){
			 secondIntersection = list.get(2);
			 dat = new Data(secondIntersection,ceil.getKey(),getUpper.getKey(),0,true,true);
			 dat.setCircleFirstInter(ceil);
			 dat.setCircleSecondInter(getUpper);
			}
		//	if(!AlreadyInserted(ceil.getyCo() ,getUpper.getyCo(),secondIntersection) ){
			if(secondIntersection >= point){
			pq.insert(dat);
			this.addIntersction(ceil,getUpper,secondIntersection);
			}
		//	if((int)FirstIntersectionP == (int)secondIntersection && list.size() >3){
		//		pq.insert(data);
		//		this.addIntersction(ceil.getyCo(),getUpper.getyCo(),FirstIntersectionP);

		//	    }
		//	}
		//	if(!AlreadyInserted(ceil.getyCo() ,getUpper.getyCo(),FirstIntersectionP)  &&list.size() > 3){
		//		this.addIntersction(ceil,getUpper,FirstIntersectionP);
			if(secondIntersection >= point){
				pq.insert(data);
			     }
		//		}
         	}

        }
	
	private boolean areChecked(SemiCircle getUpper, SemiCircle ceil) {
		if(this.stt.get(getUpper.getyCo()) != null){
			Queue<IntersectionData> q = this.stt.get(getUpper.getyCo());
			while(!q.isEmpty()){
				IntersectionData d = q.dequeue();
				if(d.getFirstKey() == ceil.getyCo()){
			return true;
		}
		}
	 }
		return false;
	}

	
	

	/*
	private boolean areChecked(SemiCircle getUpper, SemiCircle ceil) {
		for(int i = 0; i <k;i++){
			if(this.first[i] == getUpper.getyCo() && this.second[i] == ceil.getyCo() || this.first[i] == ceil.getyCo()  && this.second[i] == getUpper.getyCo()){
			return true;
			}
		}
		return false;
	}*/

	
	private void addIntersction(SemiCircle ceil, SemiCircle getUpper,double point) {		
		this.stt.put(ceil.getyCo(), new IntersectionData(getUpper.getyCo()));
		this.stt.put(getUpper.getyCo(), new IntersectionData(ceil.getyCo()));
	}


	
/*
	int k= 0;
	int j = 0;
	int l = 0;
	int p = 0;
	int r = 0;
	private void addIntersction(double firstKey, double secondKey,double point) {		
		System.out.println("added intersection " + point + " keys " + firstKey + " and  " + secondKey);
		this.first[k++] = firstKey;
		this.second[j++] = secondKey;
	}

	private boolean AlreadyInserted(double key, double key2, double d) {
		for(int i = 0; i <first.length;i++ ){
			if((first[i] == key && second[i] == key2  && this.intersectIonPoints[i] == (int) d) || first[i] == key2 && second[i] == key && this.intersectIonPoints[i] == (int)d){
				return true;
			}
		}
		return false;
	}
	*/
}

	
	

	

