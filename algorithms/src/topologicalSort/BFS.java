package topologicalSort;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	
	public static void searchGraph(Graph graph) {
		graph.markAllUnexplored();

		for (Node n : graph.allNodes) {
			if (!n.isVisited) {
				searchFromSpecifiedNode(n);
			}
		}
	}

	public static void searchFromSpecifiedNode(Node startNode) {

		Queue<Node> allNodesQueue = new LinkedList<Node>();
		allNodesQueue.add(startNode);

		while (!allNodesQueue.isEmpty()) {
			Node poppedNode = allNodesQueue.poll();
			poppedNode.setVisited(true);
			System.out.println("Visited Node: " + poppedNode.toString());
			for (Node neighbor : poppedNode.adjNodes) {
				if (!neighbor.isVisited) {
					allNodesQueue.add(neighbor);
				}
			}
		}
	}
}
