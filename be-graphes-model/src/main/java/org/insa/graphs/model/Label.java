package org.insa.graphs.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Label {

    // number of the node associated with this label
    private int currentNodeId;
    
    //corresponding node
    private Node currentNode;

    // true when the min cost of this node is known by the algorithm
    private Boolean marked;

    // cost of the shortest path from the origin to the Node
    private double cost;
    
    //precedent node on shortest current path
    private int fatherId;


    public Label(int currentNodeId, Boolean marked, double cost, int fatherId) {
        this.currentNodeId = currentNodeId;
        this.currentNode = nodes.get(currentNodeId);
        this.marked = marked;
        this.cost = cost;
        this.fatherId = fatherId;
    }
    
    public getCost(Label label) {
    	return this.cost;
    }
    
    /**
    * @deprecated
    */
   // public compareTo() {
    //	return null;
    //}

}
 