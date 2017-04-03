package stronglyConnectedComponents;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
	HashMap<Node,ArrayList<Node>> map = new HashMap<>();
	
	public void addEdge(Integer fromVertex, Integer toVertex, Graph graph){
		Node fromNode = new Node(fromVertex);
		Node toNode  = new Node(toVertex);
		addEdge(fromNode, toNode, graph);
	}
	
	public void addEdge(Node fromNode, Node toNode, Graph graph){
		if(graph.map.containsKey(fromNode)){
			ArrayList<Node> valueNodes = graph.map.get(fromNode);
			valueNodes.add(toNode);
			graph.map.put(fromNode, valueNodes);
		}else{
			ArrayList<Node> valueNode = new ArrayList<Node>();
			valueNode.add(toNode);
			graph.map.put(fromNode,valueNode);
		}
	}
}
