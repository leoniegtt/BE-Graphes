package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.algorithm.shortestpath.LabelStar;
import org.insa.graphs.model.Node;


public class AStarAlgorithm extends DijkstraAlgorithm {

    public AStarAlgorithm(ShortestPathData data) {
        super(data);
        

    }
    
    //create new array of labelstars
	Label[] InitLabels(ShortestPathData data) {
		//initialization of the labels (see label.java)
        LabelStar[] labels = new LabelStar[data.getGraph().size()];
        //int destination = data.getDestination().getId();
        for (Node node : data.getGraph().getNodes()) {
        	labels[node.getId()]=new LabelStar(node.getId() );
        }
        return labels;
	}
    
}
