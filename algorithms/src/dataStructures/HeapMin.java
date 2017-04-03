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
		if(nodeIndex)
		Node node = this.heap.get(nodeIndex);
		//left and right child of Node are at 2i+1 and 2i+2 respectively
		int leftIndex = 2 * nodeIndex + 1;
		int rightIndex = 2 * nodeIndex + 2;
		
		int minIndex = Math.min(leftIndex, rightIndex);
		//swap Node at nodeIndex with it's minimum child
		Node minChild = this.heap.get(minIndex);
		if(minChild.getNodeId() > node.getNodeId()){
			// swap them and sift paretn(node) down
			this.heap.set(nodeIndex, minChild);
			this.heap.set(minIndex, node);
			
			nodeIndex= minIndex;
			heapify(nodeIndex);
			/*
			node = this.heap.get(nodeIndex);
			leftIndex = 2 * nodeIndex + 1;
			rightIndex = 2 * nodeIndex + 2;
			minIndex = Math.min(leftIndex, rightIndex);
	*/	}
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
