package topologicalSort;


public class Node {
	Integer id;
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
	public Integer getLabel(){
		return this.finishingLabel;
	}
	
	public  void setLabel(Integer newLabel){
		this.finishingLabel = newLabel;
	}
	

}
