package assignment5_f20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class DiGraph implements DiGraphInterface {

  // in here go all your data and methods for the graph
	HashMap<String, Node> nodeVals = new HashMap<String, Node>();		//storing Nodes(Vertex); each node has info of Dlables
	ArrayList<Long> listOfNodeIDs = new ArrayList<Long>();				//store NodeID's
	ArrayList<Long> listOfEdgeIDs = new ArrayList<Long>();				//store EdgeID's
	
    Set<Node> VisitedNodes = new HashSet<Node>(); 						//Visited Nodes
    HashMap<Node, Long> Cost = new HashMap<Node, Long>();				//Cost of weights per each Dlabel'


  public DiGraph ( ) { // default constructor
    // explicitly include this
    // we need to have the default constructor
    // if you then write others, this one will still be there
  }

	@Override
	public boolean addNode(long idNum, String label) {
		if(nodeVals.get(label) != null || idNum < 0) {
			// if idNum returns something that isn't  null, 
			// since there's something there already
			// we gonna return false
			// this also verifies that incoming lable 
			// does not exist in HashTable if attempting 
			// to make a unique value
			return false;
		}
		// check if id is unique!!!!!!!!!
		for(long i: listOfNodeIDs) {
			if(i == idNum) {
				return false;
			}
		}
		//stores node
		nodeVals.put(label, new Node(idNum, label));
		listOfNodeIDs.add(idNum);
		//list of idnumbers 
		return true;
	}

	@Override
	public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		if (idNum < 0 || weight < 0) {	//checks if ID and weight is not less than 0
			return false;
		}
		if (!nodeVals.containsKey(dLabel) || !nodeVals.containsKey(sLabel)) {		//checks dlabel and slabel are nodes already stores

			return false;
		}
		for(long i: listOfEdgeIDs) {	//checks uniqueness of Edge ID
			System.out.println(i);
			if(i == idNum) {

				return false;
			}
		}
		if(nodeVals.get(sLabel).edgeExist(dLabel)) {
		//	System.out.println("Came here");

			return false;
		}
		listOfEdgeIDs.add(idNum);
		nodeVals.get(sLabel).addEdge(dLabel, new Edge(idNum, sLabel, dLabel, weight, eLabel));
	//	System.out.println(listOfEdgeIDs.size());
	// check if id is unique!!!!!!!!! make a list
	// nodeVals.put(idNum,dLabel);
	// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean delNode(String label) {
		if(nodeVals.containsKey(label)) {
			listOfEdgeIDs.remove(nodeVals.get(label).getIdNum());
			nodeVals.remove(label);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean delEdge(String sLabel, String dLabel) {
		if(!nodeVals.containsKey(sLabel) || !nodeVals.containsKey(dLabel)) {
			return false;
		}
		if(nodeVals.get(sLabel).edgeExist(dLabel)) {
			//System.out.println("gonna delete " + nodeVals.get(sLabel).getEdgeID(dLabel));

			listOfEdgeIDs.remove(nodeVals.get(sLabel).getEdgeID(dLabel));
			nodeVals.get(sLabel).delEdge(dLabel);
			return true;
		}
		return false;
	}
	
	@Override
	public long numNodes() {
		// TODO Auto-generated method stub
		return nodeVals.size();
	}
	
	@Override
	public long numEdges() {		
		// TODO Auto-generated method stub
		return listOfEdgeIDs.size();
	}
	
	public ShortestPathInfo[] shortestPath(String label) {
		ShortestPathInfo[] infoArray = new ShortestPathInfo[nodeVals.size()];
		infoArray[0] = new ShortestPathInfo(label, 0);
	    MinBinHeap minHeap = new MinBinHeap(nodeVals.size());
		minHeap.insert(new NodePriorityFrame(nodeVals.get(label), 0));
		int counter = 0;
		while(minHeap.size() != 0) {
			Node currentNode = minHeap.getMin().getValue(); 	//gets min 
			System.out.println(currentNode);
			long distance = currentNode.distance();
			minHeap.delMin(); 									//  delete  min
			if(!VisitedNodes.contains(currentNode)) { 			// check if Nodes being examined have already been visited nodes
				System.out.println("Insert Node: " + currentNode.getLabel());
				VisitedNodes.add(currentNode);
				int weight = 0;
				System.out.println("Current node has edges? : " + currentNode.getEdgeMap());
				for(String key : currentNode.getEdgeMap().keySet()) {			// for all nodes adjacent to current node
					weight = (int) currentNode.getWeight(key);
					int checkDistance = (int) (weight + distance);
					if(nodeVals.get(key).distance >  checkDistance || nodeVals.get(key).distance == 0) {			//check
						nodeVals.get(key).distance = checkDistance;
						minHeap.insert(new NodePriorityFrame(nodeVals.get(key), (int) checkDistance));
					}
				}
				infoArray[counter] = new ShortestPathInfo(currentNode.getLabel(), currentNode.distance());
				counter++;
			}
		}
					
		if(counter < nodeVals.size()) {
			System.out.println(nodeVals.keySet());
			for(String key : nodeVals.keySet()) {
				if(!VisitedNodes.contains(nodeVals.get(key))) {
					nodeVals.get(key).distance = -1;
					infoArray[counter] = new ShortestPathInfo(nodeVals.get(key).getLabel(), nodeVals.get(key).distance);
					counter++;
				}
			}
		}
		return infoArray;
	}
		
}