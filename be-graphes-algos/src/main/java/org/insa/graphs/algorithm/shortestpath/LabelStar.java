package org.insa.graphs.algorithm.shortestpath;

//import org.insa.graphs.model.Arc;
	
public class LabelStar extends Label implements Comparable<Label> {
			
	//total cost
	private double otherCost;
	

	public LabelStar(int currentNodeId) {
		//super(currentNodeId, marked, cost, father);
		super(currentNodeId);
		this.otherCost = 0;
	}
	
	//get functions
	public double getOtherCost() {
		return this.otherCost;
	}
	 
	public double getTotalCost(double cost) {
		return this.getOtherCost() + this.getCost();
			
	}
	
	public int getFatherId() {
		return this.getFather().getDestination().getId();
	}
	 
	 //set functions
	 public void SetOtherCost(double otherCost) {
		 this.otherCost = otherCost;
	 }
}
 
