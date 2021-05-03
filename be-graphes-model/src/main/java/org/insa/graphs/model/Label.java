package org.insa.graphs.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Label {

    // number of the node associated with this label
    private int currentVertex;

    // true when the min cost of this node is known by the algorithm
    private Boolean marked;

    // cost of the shortest path from the origin to the Node
    private double cost;
    
    //precedent node on shortest current path
    private Node father;


    public Label(int currentVertex, Boolean marked, double cost, Node father) {
        this.currentVertex = currentVertex;
        this.marked = marked;
        this.cost = cost;
        this.father = father;
    }
    
    public getCost() {
    	return this.cost;
    }
    
    /**
    * @deprecated
    */
   // public compareTo() {
    //	return null;
    //}

}
 