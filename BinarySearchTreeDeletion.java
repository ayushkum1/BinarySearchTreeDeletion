package com.app.binary_search_tree;

public class BinarySearchTreeDeletion {

	TreeNode root;
	
	public BinarySearchTreeDeletion() {
		root = null;
	}

	public class TreeNode {
		int data;
		TreeNode leftChild;
		TreeNode rightChild;
	}

	//optimized insertion
	public void insertElement(int num) {

		TreeNode current = root;
		TreeNode previous = null;

		TreeNode node = new TreeNode();
		node.data = num;
		node.leftChild = null;
		node.rightChild = null;

		while (current != null) {
			previous = current;
			
			if (num < current.data) {
				current = current.leftChild;
			} else {
				current = current.rightChild;
			}

		}

		if (previous == null) {
			root = node;
			return;
		} 
		
		if (num < previous.data) {
			previous.leftChild = node;
		} else {
			previous.rightChild = node;
		}

	}

	/*
	 * DELETION
	 */

	public void deleteElement(int num) {

		TreeNode isNode, isParentNode;// is : inorder successor, will be used when we have both left and right child existing 
									  //for a node whose data is to be deleted

		TreeNode current = root;
		TreeNode previous = null;

		//get the current pointing to the node which has the required data
		while (current != null && current.data != num) {
			previous = current;

			if (num < current.data) {
				current = current.leftChild;//if num(data) is less than current nodes data then go to left node
			} else {
				current = current.rightChild;//if num(data) is greater than current nodes data then go to right node
			}
		}

		//if current is null that means tree doesnt have any node
		if (current == null) {
			System.out.println("empty");
			return;
		}

		// non leaf node, i.e. the node has left child or right child or both
		while (current.leftChild != null || current.rightChild != null) /* not a leaf node condition */ {
			// if node has one child, either left or right
			if (current.leftChild != null && current.rightChild == null
					|| current.leftChild == null && current.rightChild != null)/* XOR operation, as only OR operation 
												will be true for node having both childs, but we need only one node*/ 
			{
				if (current.leftChild != null) /*if it has left child*/
				{
					//swap the data with the left child's data
					int tempVal = current.data;
					current.data = current.leftChild.data;
					current.leftChild.data = tempVal;
				} else /*it has right child*/
				{
					//swap the data with the right child's data
					int tempVal = current.data;
					current.data = current.rightChild.data;
					current.rightChild.data = tempVal;
				}

				//make previous point to the node before current, as we cant traverse back in binary tree, 
				//so need previous, this will be used in deleting the node containing data
				previous = current;

				if (current.leftChild != null) {
					current = current.leftChild;
				} else {
					current = current.rightChild;
				}

				continue;//keep on doing unless it becomes a leaf node
			}

			// has 2 child, inorder successor concept to be used
			//need isParentNode and isNode, doing this to make the current node to a leaf node
			isParentNode = current;
			isNode = current.rightChild;

			while (isNode.leftChild != null) /*checking isNode has a left child, if it has, keep on traversing until there are no leaf nodes*/
			{
				isParentNode = isNode;
				isNode = isNode.leftChild;
			}
			
			//after getting the isNode and isParentNode, swap the isNodes data with currents data and make previous the isParentNode as 
			//previous will be used to delete the node
			int tempVal = current.data;
			current.data = isNode.data;
			isNode.data = tempVal;
			current = isNode;
			previous = isParentNode;

			continue;

		}

		// deleting root, the only element in the tree
		if (current == root) {
			System.out.println("popped element is : " + root.data);
			root = null;
			return;
		}

		if(current == previous.leftChild) {
			System.out.println("popped element is : " + current.data);
			previous.leftChild = null;//using previous to delete its left node(leaf node)
		}
		else {
			System.out.println("popped element is : " + current.data);
			previous.rightChild = null;//using previous to delete its right node(leaf node)
		}

	}

	public boolean find(int num) {
		return find(root, num);
	}

	private boolean find(TreeNode node, int num) {

		if (node == null) {
			return false;
		}

		if (node.data == num) {
			return true;
		}

		if (num > node.data) {
			return find(node.rightChild, num);
		}

		if (num < node.data) {
			return find(node.leftChild, num);
		}

		return false;
	}

	public void printTree() {
		printTree(root);
	}

	private void printTree(TreeNode node) {

		if (node == null) {
			System.out.println("Empty Tree");
			return;
		}

		if (node.leftChild != null) {
			printTree(node.leftChild);
		}

		System.out.println(node.data);

		if (node.rightChild != null) {
			printTree(node.rightChild);
		}

	}

}
