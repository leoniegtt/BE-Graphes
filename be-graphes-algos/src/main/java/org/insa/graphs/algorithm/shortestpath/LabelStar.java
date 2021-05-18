package org.insa.graphs.algorithm.shortestpath;

public class LabelStar extends Label {
	
    //cost of the estimated shortest distance
    private double costDist;
    
    //total cost
    private double totalCost;

	public LabelStar(int currentNode ) {
		super(currentNode);
        this.costDist = Double.POSITIVE_INFINITY;
        this.totalCost = 0;
	}
	
	//get functions
	 public double getCostDist() {
	    	return this.costDist;
	    }
	 
	 public double getTotalCost() {
	    	return this.totalCost;
	    }
	 
	 //set functions
	 public void SetCostDist(double costDist) {
	    	this.costDist = costDist;
	    }
	 
	   public void SetTotalCost(double totalCost) {
	    	this.totalCost = totalCost;
	    }
	 
}
 