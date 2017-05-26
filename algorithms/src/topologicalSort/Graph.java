package topologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class Graph {
	// Graph is shown as Node -> List of neighbouring nodes
	public HashMap<Node, ArrayList<Node>> adjMap = new HashMap<Node, ArrayList<Node>>();
	public HashSet<Node> allNodes = new HashSet<Node>();

	public void addEdge(Integer startNodeId, Integer endNodeId) {
		Node startNode = new Node(startNodeId);
		Node endNode = new Node(endNodeId);
		addEdge(startNode, endNode);
	}

	public void addEdge(Node startNode, Node endNode) {
		if (!adjMap.containsKey(startNode)) {
			ArrayList<Node> neighbour = new ArrayList<Node>();
			neighbour.add(endNode);
			adjMap.put(startNode, neighbour);
			allNodes.add(startNode);
			allNodes.add(endNode);
		} else {
			// append to existing neighbours of startNode
			ArrayList<Node> neighbours = adjMap.get(startNode);
			neighbours.add(endNode);
			adjMap.put(startNode, neighbours);
			allNodes.add(endNode);
		}
	}

	public void markAllUnexplored() {
		for (Node n : allNodes) {
			n.setVisited(false);
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
