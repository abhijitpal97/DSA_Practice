package com.example.microsoftpractice;

import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/validate-binary-search-tree/description/

public class validateBST {
	TreeNode prev = null;
	public boolean isValidBST(TreeNode root) {
		if(root == null) return true;

		boolean left = isValidBST(root.left);
		if(prev != null && prev.val>=root.val) return false;
		else prev = root;
		boolean right = isValidBST(root.right);

		return left && right;}


}