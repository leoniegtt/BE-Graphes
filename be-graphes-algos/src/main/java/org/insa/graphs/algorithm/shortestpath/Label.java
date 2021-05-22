package org.insa.graphs.algorithm.shortestpath;


import org.insa.graphs.model.Arc;
//import java.lang.Math;


public class Label implements Comparable<Label>{

    // id of current node
    private int currentNodeId;

    // true when the min cost of this node is known by the algorithm
    private Boolean marked;

    // cost of the shortest path from the origin to the Node
    private double cost;
    
    //precedent node on shortest current path
    private Arc father;


    public Label(int currentNodeId) {
        this.currentNodeId = currentNodeId;
        this.marked = false;
        this.cost = Double.POSITIVE_INFINITY;
        this.father = null ;
    }
    
    //get methods for label class
    public int getCurrentNodeId() {
    	return this.currentNodeId;
    }
    
    public Boolean isMarked() {
    	return this.marked;
    }
    
    public double getCost() {
    	return this.cost;
    }
    
    public Arc getFather() {
    	return this.father;
    }
    
    public double getOtherCost() {
    	return 0;
    }
    
    //set methods for label class
    public void Mark(Boolean marked) {
    	this.marked = marked;
    }
    
    public void SetCost(double cost) {
    	this.cost = cost;
    }
    
    public void SetFather(Arc father) {
    	this.father = father;
    }
    
 
    //compare the cost of the current label with another label
    public int compareTo(Label other) {
		 if (this.getTotalCost()==other.getTotalCost()) {
			  return Double.compare(getOtherCost(), other.getOtherCost()) ;
		  } else { 
			  return Double.compare(getTotalCost(), other.getTotalCost()); 
		  }
		 
    }
    
    //A* modification
    public double getTotalCost() {
	   return this.getCost()+this.getOtherCost();
   }
}
 
