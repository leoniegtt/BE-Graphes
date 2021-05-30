package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Node;
import org.insa.graphs.algorithm.shortestpath.Label;

	
public class LabelStar extends Label implements Comparable<Label> {
		
	protected double otherCost;
		
	public LabelStar(Node node, boolean marked, double cost, Arc father, Node destination, boolean length) {
		super(node, marked, cost, father);
		if (length) {
			this.otherCost = destination.getPoint().distanceTo(node.getPoint());
		}
		else {
			this.otherCost = destination.getPoint().distanceTo(node.getPoint()) / 50 ;//convert to speed
		}
	}
	
	 public double getOtherCost() { 
		 return otherCost;
	 }
	 
	 public double getTotalCost() {
	    return this.getCost()+this.getOtherCost();
	 }
	
    
}
 
