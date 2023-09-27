package com.example.amazonpractice;

import com.example.datastructure.skeleton.TreeNode;

// https://www.codingninjas.com/studio/problems/longest-univalue-path_985291?topList=top-amazon-coding-interview-questions

public class LongestUniValuePath {
	static int max = Integer.MIN_VALUE;
	public static int longestUnivaluePath(TreeNode root) {
		// Write your code here
		max = Integer.MIN_VALUE;
		function(root);
		return max;
	}

	static int function(TreeNode root)
	{
		if(root == null) return 0;

		int left = function(root.left);
		int right = function(root.right);

		int leftMaxPath = 0;
		int rightMaxPath = 0;

		if (root.left != null && root.left.val == root.val) {
			leftMaxPath += left + 1;
		}

		// If curr node and it's right child has same value.
		if (root.right != null && root.right.val == root.val) {
			rightMaxPath += right + 1;
		}

		max = Math.max(max , leftMaxPath+rightMaxPath);

		return Math.max(leftMaxPath , rightMaxPath);

	}
}