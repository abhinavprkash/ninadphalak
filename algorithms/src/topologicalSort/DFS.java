package topologicalSort;


public class DFS {
	
	public static void search(Graph graph) {

		graph.markAllUnexplored();
		// Do a DFS on all nodes in a graph
		for(Node node : graph.allNodes) {
				if(graph.isExploredMap.get(node)==false){
				searchFromSpecifiedNode(graph, node);
			}
		}
	}
	

	public static void searchFromSpecifiedNode(Graph graph, Node node) {
		graph.isExploredMap.put(node,true);
		System.out.print("\nVisited Node: " + node.toString());
		// Do DFS on all its neighbors
		if(graph.adjMap.get(node) != null){
			for (Node neighbor : graph.adjMap.get(node)) {
				if (graph.isExploredMap.get(neighbor) == false) {
					searchFromSpecifiedNode(graph, neighbor);
				}
			}
		
		}

	}
}
