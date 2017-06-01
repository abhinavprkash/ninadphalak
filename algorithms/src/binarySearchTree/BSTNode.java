/*package binarySearchTree;



//Incomplete
public class BSTNode {
	int data;
	BSTNode left;
	BSTNode right;

	public BSTNode(int d, BSTNode left, BSTNode right) {
		this.data = d;
		this.left = left;
		this.right = right;
	}

	public void insertInOrder(BSTNode node) {
		if (node.data < this.data) {
			// go left
			if (left != null) {
				left.insertInOrder(node);
			} else {
				this.left = node;
			}
		}
		if (node.data > this.data) {
			// go right
			if (right != null) {
				right.insertInOrder(node);
			} else {
				this.right = node;
			}
		}
	}

	public BSTNode delete(BSTNode nodeToDelete) {
		if (this.data == nodeToDelete.data){
			
		}
				
				
		if(nodeToDelete.data < this.data)
		{
			left.delete(nodeToDelete);
			}
		if(nodeToDelete.data > this.data){
			right.delete(nodeToDelete);
		}
		
		
	}


}
*/