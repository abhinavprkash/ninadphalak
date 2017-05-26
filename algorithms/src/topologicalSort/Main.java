package topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) throws IOException{
		//get input graph from user, as a path to the graph file
		//graph input is represented as one edge per line by startNode endNode 
		String inputPath = "D:\\git_repo\\ninadphalak\\algorithms\\resources\\topologicalSort\\simpleGraph.txt";
		//String inputPath = args[0];
		Path path = Paths.get(inputPath);
		BufferedReader reader = Files.newBufferedReader(path);
		String line = null;
		Graph graph = new Graph();
		while((line = reader.readLine())!= null){
			if(line.isEmpty() || line.trim().equals("") || line.trim().equals("/n")){
				continue;
			}
			System.out.println("Input line " + line.toString());
			String[] edge = line.split(" ");
			Integer startNodeId = Integer.parseInt(edge[0]);
			Integer endNodeId = Integer.parseInt(edge[1]);
			graph.addEdge(startNodeId, endNodeId);
		}
		System.out.println("Stored Graph: " + '\n' + graph.toString());
		System.out.println("DFS of graph is: \n");
		DFS.search(graph);
		System.out.println("\nBFS of graph is: \n" );
		BFS.searchGraph(graph);
		System.out.println("\nTopologically sorted graph is: ");
		topologicalSort.sort(graph);
		for(Node n : graph.allNodes){
			System.out.println(n.toString() + " has finishingLabel: "+  n.finishingLabel);
		}
		
		
	}
}
