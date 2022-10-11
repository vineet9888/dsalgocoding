package com.ds.algo.problem.solving.trees;

public class AllNodesAtDistanceKFromTarget {
	
	
	public void printKNodeDistanceDown(TreeNode targetNode , int k) {
		if(targetNode == null) {
			return;
		}
		
		if(k == 0) {
			System.out.println(targetNode.val);
			return;
		}
		
		printKNodeDistanceDown(targetNode.left, k - 1);
		printKNodeDistanceDown(targetNode.right, k - 1);
		
	}
	
	public int printKNodeDistance(TreeNode root , TreeNode target , int k) {

		// in case target node is not found
		if(root == null) {
			return -1;
		}
		
		// if target is found....
		// then print all the children of target which are at k distance from target
		if(root == target) {
			printKNodeDistanceDown(root, k);
			return 0;
		}
		
		// start with the left subtree...
		// dl is the distance of target node from current root.
		int dl = printKNodeDistance(root.left, target, k);
		if(dl != -1) {
			// check if the immediate right child is at distance k
			if(dl + 1 == k) {
				System.out.println(root.val);
			} else {
				printKNodeDistanceDown(root.right, k -dl-2);
			}
			return dl + 1;
		}
		
		int dr = printKNodeDistance(root.right , target , k);
		if(dr != -1) {
			if(dr + 1 == k) {
				System.out.println(root.left);
			} else {
				printKNodeDistanceDown(root.left, k - dr-2);
			}
			return dr + 1;
		}
		
		return -1;
		
	}
	

	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(12);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);
		root.right = new TreeNode(22);
	}
	
}


