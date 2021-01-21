package com.app.binary_search_tree;

public class BSTTester {

	public static void main(String[] args) {

		BinarySearchTreeDeletion bTree = new BinarySearchTreeDeletion();

		bTree.insertElement(13);
		bTree.insertElement(11);
		bTree.insertElement(10);
		bTree.insertElement(16);
		bTree.insertElement(8);
		bTree.insertElement(2);
		bTree.insertElement(20);
		bTree.insertElement(25);
		bTree.insertElement(29);
		bTree.insertElement(23);

		bTree.printTree();

		System.out.println("NO exists : " + bTree.find(100));
		System.out.println("NO exists : " + bTree.find(10));
		System.out.println("NO exists : " + bTree.find(02));
		System.out.println("NO exists : " + bTree.find(8));
		bTree.deleteElement(10);
		bTree.deleteElement(20);
		bTree.deleteElement(25);
		bTree.deleteElement(2);
		bTree.deleteElement(8);
		bTree.deleteElement(16);
//		System.out.println("Element popped : " + );
////		System.out.println(bTree.deleteElement(20));
//		System.out.println("Element popped : " + );
////		System.out.println("Element popped : " + bTree.deleteElement(10));

//		bTree.printTree();
		bTree.deleteElement(13);
		bTree.printTree();
		

		bTree.deleteElement(29);
		bTree.deleteElement(23);
		bTree.deleteElement(11);
		bTree.printTree();
	}

}
