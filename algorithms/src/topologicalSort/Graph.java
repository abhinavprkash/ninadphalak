package topologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class Graph {
	// Graph is shown as Node -> List of neighbouring nodes
	HashMap<Node, ArrayList<Node>> adjMap = new HashMap<Node, ArrayList<Node>>();
	HashMap<Node, Boolean> isExploredMap = new HashMap<Node, Boolean>();
	Set<Node> allNodes = new HashSet<Node> ();
	//for detecting cycle
	HashMap<Node, Boolean> isOnStackMap = new HashMap<Node,Boolean>();
	
	
	public void addEdge(Integer startNodeId, Integer endNodeId) {
		Node startNode = new Node(startNodeId);
		Node endNode = new Node(endNodeId);
		addEdge(startNode, endNode);
	}

	public void addEdge(Node startNode, Node endNode) {
		if (!adjMap.containsKey(startNode)) {
			//create new arrayList
			ArrayList<Node> neighbours = new ArrayList<Node>();
			neighbours.add(endNode);
			adjMap.put(startNode, neighbours);
			//add to list of nodes isExploredMap
			isExploredMap.put(startNode, false);
			isExploredMap.put(endNode, false);
			//add to allNodes
			allNodes.add(startNode);
			allNodes.add(endNode);
			//add to isOnStackMap
			isOnStackMap.put(startNode,false);
			isOnStackMap.put(endNode,false);
			
			
		} else {
			// append to existing neighbours of startNode
			ArrayList<Node> neighbours = adjMap.get(startNode);
			neighbours.add(endNode);
			adjMap.put(startNode, neighbours);
			//add to list of nodes isExploredMap
			isExploredMap.put(endNode, false);
			//add to allNodes
			allNodes.add(endNode);
			//add to isOnStackMap
			isOnStackMap.put(endNode, false);
		}
	}

	public void markAllUnexplored() {
		for (Entry<Node, Boolean> entry : isExploredMap.entrySet()) {
			entry.setValue(false);
			entry.getKey().setLabel(-1);
		}
		

	
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Entry<Node, ArrayList<Node>> entry : adjMap.entrySet()) {
			Node key = entry.getKey();
			String adjNodes = entry.getValue().toString();
			sb.append(key.toString() + "=>" + adjNodes + '\n');
		}
		return sb.toString();
	}

}
