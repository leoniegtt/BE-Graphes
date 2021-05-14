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
        BinaryHeap<Label> heap = new BinaryHeap<Label>();
        
        //retrieve the graph and its size
        Graph graph = data.getGraph();
        final int nbNodes = graph.size();
        
        //initialization of the labels (see label.java)
        Label[] labels = new Label[nbNodes];
        for (int i=0; i<nbNodes;i++) {
        	labels[i]=new Label(i);
        }
        
        //initialization of first node and new graph
        int originId = data.getOrigin().getId();
        labels[originId].SetCost(0);
        labels[originId].Mark(true);
        heap.insert(labels[originId]);

        //**start of the algorithm**
        //boolean representing if there exists unmarked nodes
        boolean Unmarked = true;
        
        //main loop while there are unmarked nodes and the heap isn't empty
        while (Unmarked && !heap.isEmpty()) {
        	Label min = heap.findMin();
        	heap.deleteMin();
        	int minId = min.getCurrentNodeId();
        	labels[minId].Mark(true);
        	Node minNode = graph.get(minId);
        	
	        for(Arc successor: minNode.getSuccessors() ) {
	        	Node currentNode = successor.getDestination();
	        	int nodeId = currentNode.getId();
	        	Label y = labels[nodeId];
	        	
	        	if (!y.isMarked()) {
	        		//y.SetCost(Math.min(y.getCost(), min.getCost()+successor.getLength()));
	        		double weight = data.getCost(successor);
	        		double oldCost = y.getCost();
	        		double newCost = labels[minId].getCost() + weight;
	        		
	        		if (oldCost > newCost) {
	        			y.SetCost(newCost);
	        			y.SetFather(successor);
	        			try {
	        				heap.remove(y);
	        				heap.insert(y);
	        			} catch (Exception ElementNotFoundException){
	        				heap.insert(y);
	        			}
	        				
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
