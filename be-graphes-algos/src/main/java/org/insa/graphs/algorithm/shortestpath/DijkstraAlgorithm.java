package org.insa.graphs.algorithm.shortestpath;

import java.util.ArrayList;
import java.util.Collections;

import org.insa.graphs.model.Node;
import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Path;
import org.insa.graphs.model.Graph;

import org.insa.graphs.algorithm.shortestpath.Label;
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
        int nbNodes = graph.size();
        
        //initialization of the labels (see label.java)
        Label[] labels = new Label[nbNodes];
        //for (int i=0; i<nbNodes;i++) {
        for (Node node : graph.getNodes()) {
        	labels[node.getId()]=new Label(node.getId());
        }
        
     // Notify observers about the first event (origin processed).
        notifyOriginProcessed(data.getOrigin());
        
        //initialization of first node and new graph
        int originId = data.getOrigin().getId();
        labels[originId].SetCost(0);
        labels[originId].Mark(true);
        heap.insert(labels[originId]);

        
        //**main part of the algorithm**
        //boolean representing if there exists unmarked nodes (stop the algorithm if not)
        boolean Unmarked = true;
        
        //main loop while there are unmarked nodes and the heap isn't empty
        while (Unmarked && !heap.isEmpty()) {
        	
        	//find min element in heap
        	Label min = heap.deleteMin();
        	int minId = min.getCurrentNodeId();
        	labels[minId].Mark(true);
        	
        	Node minNode = graph.get(minId);
        	
			//Notify all observers that the node has been marked
			notifyNodeMarked(minNode);
        	
			//check that the cost of the marked labels is increasing
        	//System.out.println("cost of label " + labels[minId].getCost() +" = " + labels[minId].getCost());
        	
			//to check nb successors coherent later
        	//int count = 0;
        	
        	//find closest successor of said element
	        for(Arc successor: minNode.getSuccessors() ) {
	        	count++;
	        	Node currentNode = successor.getDestination();
	        	int nodeId = currentNode.getId();
	        	Label y = labels[nodeId];
	        	
	        	//check allowed roads (select for cars)
	        	if (!data.isAllowed(successor)) {
	        		continue;
	        	}
	        	
	        	//if node unmarked : check if shorter path
	        	if (!y.isMarked()) {
	        		double weight = data.getCost(successor);
	        		double oldCost = y.getCost();
	        		double newCost = labels[minId].getCost() + weight;
	        		
	            	//notify all observers that a node has been reached for the first tim
	            	if (Double.isInfinite(oldCost) && Double.isFinite(newCost)) {
	                    notifyNodeReached(currentNode);
	                }
	            	
	        		if (oldCost > newCost) {
	        			if (Double.isFinite(oldCost)) {
	        				heap.remove(y);
	        			}
	        			
	        			y.SetCost(newCost);
	        			y.SetFather(successor);
	        			heap.insert(y);
	        		}

	        	}
	        }
	        //check that the nb of explored successors is coherent
        	//int diff = minNode.getNumberOfSuccessors() - count ;
        	//System.out.println("différence = " + diff);
	        
	        //check if the destination is marked(=arrived)
	        Unmarked = false;
        	if (!labels[data.getDestination().getId()].isMarked()) {
        			Unmarked = true;
        	}
        }
        
        
        //**building the solution**
        //check that the destination has a predecessor(=feasible solution)
        if (labels[data.getDestination().getId()].getFather()==null) {
        	solution = new ShortestPathSolution(data, Status.INFEASIBLE);
        } else {
        	
        	//Notify all observers that the destination has been reached
            notifyDestinationReached(data.getDestination());
        	
            //build the solution (create and fill arc list starting from the destination to create graph)
        	ArrayList<Arc> arcList = new ArrayList<Arc>();
        	int dest = data.getDestination().getId();
        	Arc arcDad = null;
        	while (labels[dest].getFather()!=null) {
        		arcDad = labels[dest].getFather();
        		arcList.add(arcDad);
        		dest = arcDad.getOrigin().getId();
        		//System.out.println("cost of label " + labels[dest].getCurrentNodeId() +" = " + labels[dest].getCost());
        	}
        
        //reverse the list as we started from the destination
        Collections.reverse(arcList);
            
        //build the final solution
        Path finalPath = new Path(graph, arcList);       
        solution = new ShortestPathSolution(data, Status.OPTIMAL, finalPath);
	    }
        
        return solution;
    }
}
