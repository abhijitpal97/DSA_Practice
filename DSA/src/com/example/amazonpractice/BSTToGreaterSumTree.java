package com.example.amazonpractice;

import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/description/

public class BSTToGreaterSumTree {
	int sum = 0;
	public TreeNode bstToGst(TreeNode root) {
		if(root == null) return null;

		bstToGst(root.right);

		sum += root.val;

		root.val = sum;

		bstToGst(root.left);

		return root;
	}
}