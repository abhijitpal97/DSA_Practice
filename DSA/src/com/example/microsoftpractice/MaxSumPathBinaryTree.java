package com.example.microsoftpractice;

import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

public class MaxSumPathBinaryTree {
	int max = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		max = Integer.MIN_VALUE;
		maxSum(root);
		return max;
	}

	int maxSum(TreeNode root)
	{
		if(root == null) return 0;

		int l = Math.max(0 , maxSum(root.left));
		int r = Math.max(0 , maxSum(root.right));

		max = Math.max(max , l+r+root.val);

		return Math.max(l , r)+root.val;
	}
}