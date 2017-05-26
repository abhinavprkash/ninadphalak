package topologicalSort;

public class DFS {
	
	public static void search(Graph graph) {

		graph.markAllUnexplored();
		// Do a DFS on all nodes in a graph
		for (Node node : graph.allNodes) {
			if(!node.isVisited){
			searchFromSpecifiedNode(node);
			}
		}
	}
	

	public static void searchFromSpecifiedNode(Node node) {
		node.setVisited(true);
		System.out.println("Visited Node: " + node.toString());
		// Do DFS on all its neighbors
		for (Node neighbor : node.adjNodes) {
			if (neighbor.isVisited == false) {
				searchFromSpecifiedNode(neighbor);
			}
		
		}

	}
}
