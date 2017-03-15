package kargerMinCut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class KargerMinCut {
/*	Karger Algorithm:
	1)  Initialize contracted graph G as copy of original graph
	2)  While there are more than 2 vertices.
	      a) Pick a random edge (u, v) in the contracted graph.
	      b) Merge (or contract) u and v into a single vertex (update 
	         the contracted graph).
	      c) Remove self-loops
	3) Return cut represented by two vertices.
*/
	
	public static int kargerMinCut(Graph graph){
		while(getNumOfVertices(graph) > 2){
			/* To pick a random edge, we will pick a random key i.e vertex and then iterate over the value and pick a random node
			 * So our (vertex,node) will be the random edge selected
			 */
			
		}
		return 0;
	}
	
	public Node[] getRandomEdge(Graph graph){
		String[] keys= (String[])graph.adjMap.keySet().toArray();
		Random rand = new Random();
		String randomKey = keys[rand.nextInt(keys.length)];
		String removeL = randomKey.replace("[","");
		String removeLR = removeL.replace("]", "");
		String[] keyStringArray = removeLR.split(",");
		ArrayList<Integer> id = new ArrayList<Integer>();
		for(String partKey : keyStringArray){
			id.add(Integer.parseInt(partKey));
		}
		
		Node n1 = new Node(id);
		//Second vertex should be adjacent to Node n1, so take a random node from its values
		ArrayList<Node> n1Values =	graph.adjMap.get(n1);
		int index = rand.nextInt(n1Values.size());
		Node n2 = n1Values.get(index);
		Node[] edge = {n1, n2};
		return edge;
		
	}
	
	public static int getNumOfVertices(Graph g){
		//number of vertices = total number of keys in G
		return g.adjMap.size();
	}
}
