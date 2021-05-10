package org.insa.graphs.algorithm.shortestpath;


import org.insa.graphs.model.Arc;


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
    
    //set methods for label class
    public void Mark(boolean marked) {
    	this.marked = true;
    }
    
    public void SetCost(double cost) {
    	this.cost = cost;
    }
    
    public void SetFather(Arc father) {
    	this.father = father;
    }
    
 
    //compare the cost of the current label with another label
    public int compareTo(Label other) {
    	return Double.compare(getCost(), other.getCost());
    }
}
 