package org.insa.graphs.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class Label {

    // node associated with this label (name or number)
    private final String currentNode;

    // true when the min cost of this node is known by the algorithm
    private final Boolean mark;

    // cost of the shortest path from the origin to the Node
    private final Int cost;
    
    //precedent node on shortest current path
    private final Node father;


    public Label(String currentNode, Boolean mark, int cost, Node father) {
        this.currentNode = currentNode;
        this.mark = mark;
        this.cost = cost;
        this.father = father;
    }
    
    public getCost() {
    	return this.cost;
    }
    
    /**
    * @deprecated
    */
    public compareTo() {
    }

}
 