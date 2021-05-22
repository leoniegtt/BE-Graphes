package org.insa.graphs.algorithm.shortestpath;

import java.util.ArrayList;
import java.util.Collections;

import org.insa.graphs.model.Node;
import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Path;
import org.insa.graphs.model.Graph;

import org.insa.graphs.algorithm.shortestpath.Label;
import org.insa.graphs.algorithm.shortestpath.LabelStar;
import org.insa.graphs.algorithm.AbstractSolution.Status;
import org.insa.graphs.algorithm.utils.BinaryHeap;

public class AStarAlgorithm extends DijkstraAlgorithm {

    public AStarAlgorithm(ShortestPathData data) {
        super(data);
    }

    protected ShortestPathSolution doRun() {
        final ShortestPathData data = getInputData();
        ShortestPathSolution solution = null;
        
        //**Initialization**
        //initialize binary heap
        BinaryHeap<Label> heap = new BinaryHeap<Label>();
        
        //retrieve the graph and its size
        Graph graph = data.getGraph();
        int nbNodes = graph.size();
        
        //initialization of the labels (see label.java)
        Label[] labels = new LabelStar[nbNodes];
        //for (int i=0; i<nbNodes;i++) {
        for (Node node : graph.getNodes()) {
        	labels[node.getId()]=new Label(node.getId());
        }
        
      //initialization of first node and new graph
        int originId = data.getOrigin().getId();
        labels[originId].SetCost(0);
        labels[originId].Mark(true);
        heap.insert(labels[originId]);
      
        
        return solution;
    }
    
}
