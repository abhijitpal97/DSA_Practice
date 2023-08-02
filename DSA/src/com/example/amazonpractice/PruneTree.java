package com.example.amazonpractice;

import com.example.datastructure.skeleton.TreeNode;

public class PruneTree {
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(0);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(0);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(4);

		pruneTree(root);
	}

	public static TreeNode pruneTree(TreeNode root) {
		if(root == null ) return root;
		if(!(root.val == 1 || process(root.left) || process(root.right))) return null;

		root.left = pruneTree(root.left);
		root.right = pruneTree(root.right);

		return root;
	}

	static boolean process(TreeNode root)
	{
		if(root == null) return false;
		if(root.val == 1) return true;
		return process(root.left) || process(root.right);
	}
}