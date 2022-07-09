/**
 * 
 */
package com.dsa.binarysearchtreefindsumpair;

import java.util.HashSet;
import java.util.Set;

import com.dsa.binarysearchtreefindsumpair.BSTFindSumPair;
import com.dsa.binarysearchtreefindsumpair.BSTFindSumPair.Node;

/**
 * @author Sameer
 *
 */
public class BSTFindSumPair {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = null;
		BSTFindSumPair bstFindSumPair = new BSTFindSumPair();
		root = bstFindSumPair.insertNode(root, 40);
		root = bstFindSumPair.insertNode(root, 20);
		root = bstFindSumPair.insertNode(root, 60);
		root = bstFindSumPair.insertNode(root, 10);
		root = bstFindSumPair.insertNode(root, 30);
		root = bstFindSumPair.insertNode(root, 50);
		root = bstFindSumPair.insertNode(root, 70);
		int sum = 131;
		bstFindSumPair.findPairWithGivenSum(root, sum);
							  /*
					        40
					     /      \
					   20        60
					 /   \      /   \
					10   30    50   70    */
	}

	static class Node {
		int nodeData;
		Node leftNode, rightNode;
	};

	static Node newNode(int nodeData) {
		Node tempNode = new Node();
		tempNode.nodeData = nodeData;
		tempNode.leftNode = null;
		tempNode.rightNode = null;
		return tempNode;
	}

	public Node insertNode(Node root, int key) {

		if (root == null) {
			return newNode(key);
		}
		if (key < root.nodeData) {
			root.leftNode = insertNode(root.leftNode, key);
		} else {
			root.rightNode = insertNode(root.rightNode, key);
		}
		return root;
	}

	public boolean findPair(Node root, int sum, Set<Integer> set) {

		if (root == null) {
			return false;
		}
		if (findPair(root.leftNode, sum, set)) {
			return true;
		}
		if (set.contains(sum - root.nodeData)) {
			System.out.println("Pair is found : (" + (sum - root.nodeData) + ", " + root.nodeData + ")");
			return true;
		} else {
			set.add(root.nodeData);
		}
		return findPair(root.rightNode, sum, set);
	}

	public void findPairWithGivenSum(Node root, int sum) {
		Set<Integer> nodesSet = new HashSet<Integer>();
		if (!findPair(root, sum, nodesSet)) {
			System.out.println("Pair does not exist!");
		}
	}

}
