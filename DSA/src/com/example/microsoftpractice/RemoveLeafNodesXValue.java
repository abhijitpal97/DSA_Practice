package com.example.microsoftpractice;

import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/delete-leaves-with-a-given-value/

public class RemoveLeafNodesXValue {
	public TreeNode removeLeafNodes(TreeNode root, int target) {
		if(root == null) return null;
		if(isLeaf(root) && root.val == target) return null;

		root.left = removeLeafNodes(root.left , target);
		root.right = removeLeafNodes(root.right , target);

		if (isLeaf(root) && root.val == target)
			root = null;

		return root;
	}

	boolean isLeaf(TreeNode node)
	{
		if(node.left == null && node.right == null) return true;
		return false;
	}
}