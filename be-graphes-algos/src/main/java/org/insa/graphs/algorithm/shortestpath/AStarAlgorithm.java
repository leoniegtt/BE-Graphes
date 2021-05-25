package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.algorithm.shortestpath.LabelStar;
import org.insa.graphs.model.Node;
import org.insa.graphs.algorithm.shortestpath.Label;


public class AStarAlgorithm extends DijkstraAlgorithm {

    public AStarAlgorithm(ShortestPathData data) {
        super(data);  
    }
    
    //create new array of labelstars
	Label[] InitLabels(ShortestPathData data) {
		//initialization of the labels (see label.java)
        LabelStar[] init = new LabelStar[data.getGraph().size()];
        for (Node node : data.getGraph().getNodes()) {
        	init[node.getId()]=new LabelStar(node, false, Double.POSITIVE_INFINITY, null, data.getDestination() );
        }
        return init;
	}
}
