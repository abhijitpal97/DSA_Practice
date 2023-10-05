package com.example.microsoftpractice;

import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/diameter-of-binary-tree/

public class DiaMeterOfBinaryTree {
	int max = 0;
	public int diameterOfBinaryTree(TreeNode root) {
		max=0;
		diameterHelper(root);
		return max;
	}

	int diameterHelper(TreeNode root)
	{
		if(root == null) return 0;
		int l = diameterHelper(root.left);
		int r = diameterHelper(root.right);
		max = Math.max(max , l+r);
		return 1+Math.max(l , r);
	}
}