package topologicalSort;

public class topologicalSort {

	/*
	 * We use a DFS to do a topological sort. We could use a stack to add the
	 * visited nodes and then pop them and that would be the topologically
	 * sorted order, and this takes O(n) space. There is a slicker way that only
	 * takes O(1) space. We add a label called finishingLabel to each node and
	 * assign this finishingLabel of each node a number(currentLabel) when it is
	 * visited. currentLabel goes from N(graph size) to 1. This algorithm is as
	 * fast as DFS since we are just doing some trivial bookkeeping in addition
	 * to DFS. The drawback is, let's say you want to print all the nodes in
	 * their topologically sorted order, this would take O(nlogn) time to sort
	 * the nodes with respect to their finishing times. Even if you store them
	 * in priority queue while sorting, assuming the priority queue is
	 * efficiently implemented using heaps or self balancing binary trees, it
	 * would still take O(logn) for insertions and removals.
	 */

	static int currentLabel=-1;// Global variable

	public static void sort(Graph graph) {

		graph.markAllUnexplored();
		currentLabel = graph.allNodes.size();
		// Make current label equal to the number of nodes in the graph and
		// assign it to each node as it is being visited and decrement it
		for (Node n : graph.allNodes) {
			if (graph.isExploredMap.get(n) == false) {
				DFSsearchFromSpecifiedNode(graph, n);
			}
		}

	}

	public static void DFSsearchFromSpecifiedNode(Graph graph, Node node) {
		graph.isExploredMap.put(node, true);// overwrite existing value
		System.out.println("Visited Node: " + node.toString());
		// Do DFS on all its neighbors
		if (graph.adjMap.get(node) != null) {
			for (Node neighbor : graph.adjMap.get(node)) {
				if (graph.isExploredMap.get(neighbor) == false) {
					DFSsearchFromSpecifiedNode(graph, neighbor);
				}

			}
		
		}
		node.finishingLabel = currentLabel;
		graph.allNodes.add(node);
		System.out.println("Node " + node.toString() + " has finishing label "
				+ node.finishingLabel);
		currentLabel--;
		
	}
}
