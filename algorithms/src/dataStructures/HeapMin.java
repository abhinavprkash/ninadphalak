package dataStructures;

import java.util.ArrayList;

public class HeapMin {

	ArrayList<Node> heap = new ArrayList<Node>();

	public void insert(Node nodeToInsert) {
		// add node to the last level of left filled heap i.e to the end of
		// ArrayList and bubble up wrt parent
		this.heap.add(nodeToInsert);
		int nodeIndex = heap.size() - 1; // this will be the index of the just
											// inserted Node

		int parentIndex = getParentIndex(nodeIndex);
		Node parent = heap.get(parentIndex);
		while (parentIndex >= 0 && parent.getNodeId() > nodeToInsert.getNodeId()) {
			// means parent is greater than child, so swap them
			this.heap.set(parentIndex, nodeToInsert);
			this.heap.set(nodeIndex, parent);

			nodeIndex = parentIndex; // node is now at parent's index
			parentIndex = getParentIndex(nodeIndex); 
		}

	}
	public void heapify(int nodeIndex){
		//Node at nodeIndex is not at correct position and assume left and right subtree are min-heaps already
		if(isLeaf(nodeIndex)){
			return;
		}
		Node node = this.heap.get(nodeIndex);
		//left and right child of Node are at 2i+1 and 2i+2 respectively
		int leftIndex = getLeftChildIndex(nodeIndex);
		int rightIndex = getRightChildIndex(nodeIndex);
		
		int minIndex = Math.min(leftIndex, rightIndex);
		//swap Node at nodeIndex with it's minimum child
		Node minChild = this.heap.get(minIndex);
		if(minChild.getNodeId() > node.getNodeId()){
			// swap them and sift parent(node) down
			this.heap.set(nodeIndex, minChild);
			this.heap.set(minIndex, node);
			
			nodeIndex= minIndex;
			heapify(nodeIndex);
		}
		
	}
	
	private boolean isLeaf(int nodeIndex){
		//A leaf has a left or a right child
		if(hasLeftChild(nodeIndex) || hasRightChild(nodeIndex)){
			return false;
		}
		return true;
	}
	
	private boolean hasLeftChild(int parentIndex){
		return getLeftChildIndex(parentIndex) < this.heap.size();
	}
	
	
	private boolean hasRightChild(int parentIndex){
		return getRightChildIndex(parentIndex) < this.heap.size();
	}
	
	private int getLeftChildIndex(int parentIndex){
		return parentIndex * 2 + 1;
	}
	
	private int getRightChildIndex(int parentIndex){
		return parentIndex * 2 + 2;
	}

	private int getParentIndex(int childIndex) {
		// Will calculate parentIndex of childIndex for zero based ArrayList
		// For parent at i, it's children are at 2i+1 and 2i+2
		// So to calculate parentIndex, subtract 1 from childIndex then divide
		// by 2
		int parentIndex = Math.floorDiv((childIndex - 1), 2);
		return parentIndex;
	}
}
