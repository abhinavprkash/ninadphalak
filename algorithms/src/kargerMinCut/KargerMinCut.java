package kargerMinCut;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class KargerMinCut {
	/*
	 * Karger Algorithm:
	 *  1) Initialize contracted graph G as copy of original
	 * graph 
	 * 2) While there are more than 2 vertices. 
	 * 	a) Pick a random edge (u,v) in the contracted graph. 
	 *  b) Merge (or contract) u and v into a single vertex (update the contracted graph). 
	 *  c) Remove self-loops 
	 * 3) Return cut represented by two vertices.
	 */

	public static int kargerMinCut(Graph graph) {

		while (getNumOfVertices(graph) > 2) {
			/*
			 * To pick a random edge, we will pick a random key i.e vertex and
			 * then iterate over the value and pick a random node So our
			 * (vertex,node) will be the random edge selected
			 */
			Node[] randomEdge = getRandomEdge(graph);
			// System.out.println("Random Edge is: " + randomEdge[0].toString()
			// + ", " + randomEdge[1].toString());
			contract(graph, randomEdge);
			removeSelfLoops(graph);
			// System.out.println("Contracted graph is: " + "\n" +
			// graph.toString());
		}
		return minCut(graph);
	}

	public static int minCut(Graph graph) {

		// Means graph already has less than two vertices, number of adjacent
		// nodes is equal to minCut
		Map.Entry<Node, ArrayList<Node>> entry = graph.adjMap.entrySet().iterator().next();
		// Now find number of values in entry
		return entry.getValue().size();
	}

	public static Node[] getRandomEdge(Graph graph) {

		Node[] edge = new Node[2];
		Random rand = new Random();
		int randomIndex = rand.nextInt(graph.adjMap.keySet().size());
		int i = 0;
		// **iterate over the graph keys(vertices) until i == randomIndex**
		for (Node n : graph.adjMap.keySet()) {
			if (i == randomIndex) {
				edge[0] = n;
			}
			i++;
		}
		ArrayList<Node> rndNodeValues = graph.adjMap.get(edge[0]);
		int randomIndex2 = rand.nextInt(rndNodeValues.size());
		edge[1] = rndNodeValues.get(randomIndex2);
		return edge;
	}

	public static void contract(Graph graph, Node[] edge) {

		ArrayList<Node> startVertexAdjList = new ArrayList<Node>(graph.adjMap.get(edge[0]));
		ArrayList<Node> endVertexAdjList = new ArrayList<Node>(graph.adjMap.get(edge[1]));
		// For contraction: Remove edge[1] from startVertexAdjList and edge[0]
		// from endVertexAdjList and take union of remaining values
		ArrayList<Node> startVertexAdjListMod = removeVertex(startVertexAdjList, edge[1]);
		ArrayList<Node> endVertexAdjListMod = removeVertex(endVertexAdjList, edge[0]);
		// merge above two modified lists into one super list
		ArrayList<Node> mergedAdjList = new ArrayList<Node>();
		mergedAdjList.addAll(startVertexAdjListMod);
		mergedAdjList.addAll(endVertexAdjListMod);
		ArrayList<Integer> superNodeList = new ArrayList<Integer>();
		superNodeList.addAll(edge[0].getId());
		superNodeList.addAll(edge[1].getId());
		Node superNode = new Node(superNodeList);
		// remove original edge vertices and add superNode
		graph.adjMap.remove(edge[0]);
		graph.adjMap.remove(edge[1]);
		graph.adjMap.put(superNode, mergedAdjList);
		// the superNode needs to replace each occurrence of original nodes in
		// the graph
		replaceWithSuperNode(graph, edge, superNode);
	}

	public static void replaceWithSuperNode(Graph graph, Node[] edge, Node superNode) {

		// Replace all occurrences of original two edge nodes with superNode
		Iterator<Map.Entry<Node, ArrayList<Node>>> iter = graph.adjMap.entrySet().iterator();
		Graph newGraph = new Graph();
		while (iter.hasNext()) {
			Map.Entry<Node, ArrayList<Node>> entry = iter.next();
			// Find edge nodes in the graph's values and replace them with
			// superNode
			Node key = entry.getKey();
			ArrayList<Node> nodeValues = entry.getValue();
			// while condition returns true if the list nodeValues was modified,
			// if true, add the superNode each time an edge point is removed
			while (nodeValues.remove(edge[0])) {
				nodeValues.add(superNode);
			}
			while (nodeValues.remove(edge[1])) {
				nodeValues.add(superNode);
			}
			iter.remove();
			// put back the same key but with the modified values containing
			// supernode in newGraph
			newGraph.adjMap.put(key, nodeValues);
		}
		// Add newGraph i.e modified graph back to the original graph
		graph.add(newGraph);
	}

	public static void removeSelfLoops(Graph graph) {

		// If key is same as value then it is self loop
		for (Entry<Node, ArrayList<Node>> entry : graph.adjMap.entrySet()) {
			Node key = entry.getKey();
			ArrayList<Node> value = entry.getValue();
			if (value.contains(key) && value.size() == 1) {
				graph.adjMap.remove(key);
			}
		}
	}

	public static ArrayList<Node> removeVertex(ArrayList<Node> nodeList, Node deleteNode) {

		ArrayList<Node> modifiednodeList = new ArrayList<Node>();
		for (Node n : nodeList) {
			if (!(n.equals(deleteNode))) {
				modifiednodeList.add(n);
			}
		}
		return modifiednodeList;
	}

	public static int getNumOfVertices(Graph g) {

		// number of vertices = total number of keys in G
		return g.adjMap.size();
	}
}
