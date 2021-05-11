package org.insa.graphs.algorithm.shortestpath;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.insa.graphs.model.Node;
import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Path;
import org.insa.graphs.model.Graph;
import org.insa.graphs.algorithm.AbstractSolution.Status;
import org.insa.graphs.algorithm.utils.BinaryHeap;

public class DijkstraAlgorithm extends ShortestPathAlgorithm {

	public DijkstraAlgorithm(ShortestPathData data) {
        super(data);
    }

    @Override
    protected ShortestPathSolution doRun() {
        final ShortestPathData data = getInputData();
        ShortestPathSolution solution = null;
        
        //**Initialization**
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
        
        //initialization of first node and new graph
        int OriginId = data.getOrigin().getId();
        labels[OriginId].SetCost(0);
        labels[OriginId].Mark(true);
        heap.insert(labels[OriginId]);

        //**start of the algorithm**
        //boolean representing if there exists unmarked nodes
        boolean Unmarked = true;
        
        //main loop while there are unmarked nodes and the heap isn't empty
        while (Unmarked && !heap.isEmpty()) {
        	Label min = heap.findMin();
        	heap.deleteMin();
        	int minId = min.getCurrentNodeId();
        	min.Mark(true); //modifier dans labels ou heap??????
        	Node minNode = graph.get(minId);
        	
	        for(Arc successor: minNode.getSuccessors() ) {
	        	Label y = labels[successor.getDestination().getId()];
	        	if (!y.isMarked()) {
	        		//y.SetCost(Math.min(y.getCost(), min.getCost()+successor.getLength()));
	        		double weight = min.getCost()+successor.getLength() ;
	        		if (y.getCost() > min.getCost() + weight) {
	        			y.SetCost(min.getCost() + weight);
	        			try {
	        				heap.remove(y);
	        			} catch (Exception ElementNotFoundException){
	        				heap.insert(y);
	        			}
	        				heap.insert(y);
	        				y.SetFather(successor);
	        		}
	        		y.Mark(true);
	        	}
	        	Unmarked = false;
	        	for (Label current: heap) {
	        		if (!current.isMarked()) {
	        			Unmarked = true;
	        		}
	        	}
	        }
	        //ajouter sommet à la solution
	        //gérer marquage des sommets et variable Unmarked
        }
        //vérifier que la destination à des prédécesseurs
        //si oui créer solution à partir du tas
        //solution= 
    

        return solution;
    }
}
