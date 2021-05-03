package org.insa.graphs.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Label {
	
    // node associated with this label
    private Node currentNode;

    // corresponding id
    private int currentNodeId;

    // true when the min cost of this node is known by the algorithm
    private Boolean marked;

    // cost of the shortest path from the origin to the Node
    private double cost;
    
    //precedent node on shortest current path
    private int fatherId;


    public Label(Node currentNode, Boolean marked, double cost, int fatherId) {
        this.currentNode = currentNode;
        this.currentNodeId = currentNode.getId();
        this.marked = marked;
        this.cost = cost;
        this.fatherId = fatherId;
    }
    
    //get methods for label class
    public int getCurrentNodeId() {
    	return currentNode.getId();
    }
    
    public Boolean isMarked() {
    	return this.marked;
    }
    
    public double getCost() {
    	return this.cost;
    }
    
    public int getFatherId() {
    	return this.fatherId;
    }
    
    //set methods for label class
    public void SetMarked(boolean marked) {
    	this.marked = marked;
    }
    
    public void SetCost(double cost) {
    	this.cost = cost;
    }
    
    public void SetFather(int fatherId) {
    	this.fatherId = fatherId;
    }
    
 
    //compare the cost of the current label with another label
    public double compareTo(Label other) {
    	return Double.compare(getCost(), other.getCost());
    }
}
 