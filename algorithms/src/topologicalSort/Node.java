package topologicalSort;

import java.util.ArrayList;

public class Node {
	Integer id;
	ArrayList<Node> adjNodes = new ArrayList<Node>();
	Boolean isVisited = false;
	Integer finishingLabel = null;
	
	
	public Node(int id){
		this.id = id;
	}

	@Override
	public String toString(){
		return id.toString();
	}
	
	@Override
	public boolean equals(Object other){
		if(!(other instanceof Node)){
			return false;
		}
		Node otherNode = (Node) other;
		return (this.id.equals(otherNode.id));
	}
	
	@Override 
	public int hashCode(){
		int hashCode = 1;
		hashCode = hashCode * 37 + this.id;
		return hashCode;
	}
	//Getters and Setters
	public ArrayList<Node> getAdjNodes() {
		return adjNodes;
	}

	public void setAdjNodes(ArrayList<Node> adjNodes) {
		this.adjNodes = adjNodes;
	}
	public Integer getLabel(){
		return this.finishingLabel;
	}
	
	public  void setLabel(Integer newLabel){
		this.finishingLabel = newLabel;
	}
	public Boolean IsVisited() {
		return isVisited;
	}

	public void setVisited(Boolean isVisited) {
		this.isVisited = isVisited;
	}

}
