package org.insa.graphs.algorithm.shortestpath;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.insa.graphs.model.Node;
import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Path;
import org.insa.graphs.model.Graph;

import org.insa.graphs.algorithm.shortestpath.Label;
import org.insa.graphs.algorithm.utils.BinaryHeap;

public class DijkstraAlgorithm extends ShortestPathAlgorithm {

    public DijkstraAlgorithm(ShortestPathData data) {
        super(data);
    }

    @Override
    protected ShortestPathSolution doRun() {
        final ShortestPathData data = getInputData();
        ShortestPathSolution solution = null;
        
        
        //Initialization
        //initialize binary heap
        BinaryHeap<Label> heap = new BinaryHeap();
        
        //retrieve the graph and its size
        Graph graph = data.getGraph();
        final int nbNodes = graph.size();
        
        //initialization of the labels (see label.java)
        Label[] labels = new Label[nbNodes];
        for (int i=0; i<nbNodes;i++) {
        	labels[i]=new Label(i);
        }
        
        //initialization with first node(get first node)
        int OriginId = data.getOrigin().getId();
        labels[OriginId].SetCost(0);
        labels[OriginId].Mark(true);
        heap.insert(labels[OriginId]);
       

        //start of the algorithm
        
        //Itérations
        //while there exists unmarked nodes
        //cf cours p 89
        
        
        
        
        return solution;
    }

}
