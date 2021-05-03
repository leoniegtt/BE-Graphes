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
    
    public double getCost() {
    	return this.cost;
    }
    
 
    public int compareTo(Label other) {
    	return Double.compare(getCost(), other.getCost());
    }

}
 