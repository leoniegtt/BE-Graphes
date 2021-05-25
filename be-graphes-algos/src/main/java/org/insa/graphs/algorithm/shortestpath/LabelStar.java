package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Node;
import org.insa.graphs.algorithm.shortestpath.Label;

	
public class LabelStar extends Label implements Comparable<Label> {
		
	protected double otherCost;
		
	public LabelStar(Node node, boolean marked, double cost, Arc father, Node destination) {
		super(node, marked, cost, father);
		this.otherCost = destination.getPoint().distanceTo(node.getPoint());
	}
	
	 public double getOtherCost() { 
		 return otherCost;
	 }
	 
	    public double getTotalCost() {
	 	   return this.getCost()+this.getOtherCost();
	     	//return this.getCost();
	    }
	
	/*
	 * //compare the cost of the current label with another label public int
	 * compareTo(LabelStar other) { if (this.getTotalCost()==other.getTotalCost()) {
	 * return Double.compare(getOtherCost(), other.getOtherCost()) ; } else { return
	 * Double.compare(getTotalCost(), other.getTotalCost()); } }
	 */
    
}
 
