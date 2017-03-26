package kargerMinCut;

import java.util.ArrayList;

public class Node {

	// node id can be a list of integers
	// single node would have only one value in the ArrayList, combined nodes
	// would have list of all combined node ids
	ArrayList<Integer> id = new ArrayList<>();

	public Node() {
	}

	public Node(int singeNodeId) {
		id.add(singeNodeId);
	}

	public Node(ArrayList<Integer> nodes) {
		id.addAll(nodes);
	}

	@Override
	public String toString() {

		return id.toString();
	}

	@Override
	public boolean equals(Object other) {

		if (!(other instanceof Node)) {
			return false;
		}
		Node otherNode = (Node) other;
		return this.id.equals(otherNode.id);
	}

	@Override
	public int hashCode() {

		int hashCode = 1;
		hashCode = hashCode * 37 + this.id.hashCode();
		return hashCode;
	}

	public ArrayList<Integer> getId() {

		return id;
	}
}
