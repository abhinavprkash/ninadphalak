package dataStructures;

public class Node {
	private int nodeId;

	public int getNodeId() {
		return nodeId;
	}

	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}
	
	@Override
	public boolean equals(Object other){
		if(!(other instanceof Node)){
			return false;
		}
		Node otherNode = (Node) other;
		return this.getNodeId()==otherNode.getNodeId();
	}
	
	@Override
	public int hashCode(){
		int hashCode = 1;
		hashCode = hashCode * 37 + this.getNodeId();
		return hashCode;
	}
}
