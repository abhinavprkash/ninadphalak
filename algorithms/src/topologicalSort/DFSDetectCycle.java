package topologicalSort;

//Modified DFS class that uses DFS to detect a cycle
public class DFSDetectCycle {
	public static boolean search(Graph graph) {

		graph.markAllUnexplored();
		// Do a DFS on all nodes in a graph
		for (Node node : graph.allNodes) {
			if(graph.isExploredMap.get(node)==false){
			 return(searchFromSpecifiedNode(graph,node));
			}
		}
		return false;
	}
	

	public static boolean searchFromSpecifiedNode(Graph graph, Node node) {
		graph.isExploredMap.put(node, true);
		//System.out.println("Visited Node: " + node.toString());
		graph.isOnStackMap.put(node,true);
		// Do DFS on all its neighbors
		if(graph.adjMap.get(node)!=null){
			for (Node neighbor : graph.adjMap.get(node)) {
				if(graph.isOnStackMap.get(neighbor)){
					return true;//cycle detected
				}
				if (graph.isExploredMap.get(neighbor) == false) {
					boolean isCycle = searchFromSpecifiedNode(graph,neighbor);
					if(isCycle){
						return true;
					}
				}
			}		
		
		}
		graph.isOnStackMap.put(node, false);
		return false;
	}
}
