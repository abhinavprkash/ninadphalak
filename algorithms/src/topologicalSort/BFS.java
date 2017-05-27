package topologicalSort;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public static void searchGraph(Graph graph) {
		graph.markAllUnexplored();

		for (Node n : graph.allNodes) {
			if (graph.isExploredMap.get(n) == false) {
				searchFromSpecifiedNode(graph, n);
			}
		}
	}

	public static void searchFromSpecifiedNode(Graph graph, Node startNode) {

		Queue<Node> allNodesQueue = new LinkedList<Node>();
		allNodesQueue.add(startNode);

		while (!allNodesQueue.isEmpty()) {
			Node poppedNode = allNodesQueue.poll();
			if (graph.isExploredMap.get(poppedNode) == false) {
				graph.isExploredMap.put(poppedNode, true);
				System.out.println("Visited Node: " + poppedNode.toString());
			}
			if (graph.adjMap.get(poppedNode) != null) {
				for (Node neighbor : graph.adjMap.get(poppedNode)) {
					if (graph.isExploredMap.get(neighbor) == false) {
						allNodesQueue.add(neighbor);
					}
				}
			}
		}
	}
}
