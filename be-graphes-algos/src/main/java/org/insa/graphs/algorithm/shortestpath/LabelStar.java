package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.Point;
import org.insa.graphs.model.Node;


//import org.insa.graphs.model.Arc;
	
public class LabelStar extends Label implements Comparable<Label> {
			
	private double otherCost;
	
	private Node destination;
	

	public LabelStar(Node node, Node destinations) {
		super(node);
	    this.node= node;
	    this.marked = false;
	    this.cost = Double.POSITIVE_INFINITY;
	    this.father = null ;
		this.otherCost = Point.distance(node.getPoint(), destination.getPoint());
	}
	
	//get functions
	public double getOtherCost() {
		return this.otherCost;
	}
	 
	//public double getTotalCost(double cost) {
	//	return this.getOtherCost() + this.getCost();
	//}
	 
	 //set functions
	// public void SetOtherCost(double otherCost) {
	//	 this.otherCost = otherCost;
	 //}
}
 
