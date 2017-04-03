package kargerMinCut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;


public class Graph {

	HashMap<Node, ArrayList<Node>> adjMap = new HashMap<Node, ArrayList<Node>>();

	public Graph(HashMap<Node, ArrayList<Node>> adjMap) {
		this.adjMap = adjMap;
	}

	public Graph() {
		// TODO Auto-generated constructor stub
	}

	// Prints entire graph
	@Override
	public String toString() {

		StringBuilder result = new StringBuilder();
		for (Entry<Node, ArrayList<Node>> entry : adjMap.entrySet()) {
			String pair = new String(entry.getKey().toString() + "=>" + entry.getValue().toString() + "\n");
			result.append(pair);
		}
		return result.toString();
	}

	public void add(Graph secondGraph) {

		this.adjMap.putAll(secondGraph.adjMap);
	}
}
