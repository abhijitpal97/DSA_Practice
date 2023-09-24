package com.example.amazonpractice;

import com.example.datastructure.skeleton.TreeNode;

// https://www.codingninjas.com/studio/problems/maximum-average-value-of-a-subtree_1281431?leftPanelTab=0

public class MaxAverageTree {
	static double maxAverage;
	public static double maxSubtreeAverage(TreeNode root) {
		// Write your code here.
		maxAverage = Double.MIN_VALUE - 1e9;
		postOrderTraversal(root);

		return maxAverage;
	}

	private static int[] postOrderTraversal(TreeNode currRoot) {
		// Checking if the current node is 'null'.
		if (currRoot == null) {
			int []res = {0, 0};
			return res;
		}

		// Traversing the left and right subtrees.
		int[] leftSubtreeResults = postOrderTraversal(currRoot.left);
		int[] rightSubtreeResults = postOrderTraversal(currRoot.right);

		// Finding the sum of nodes and the number of nodes.
		int currSum = leftSubtreeResults[0] + rightSubtreeResults[0] + currRoot.val;

		int currNodes = leftSubtreeResults[1] + rightSubtreeResults[1] + 1;

		// Updating the overall maximum average.
		maxAverage = Math.max(maxAverage, (double) currSum / currNodes);

		int []res = {currSum, currNodes};
		return res;
	}
}