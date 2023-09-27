package com.example.amazonpractice;

import com.example.datastructure.skeleton.TreeNode;

// https://practice.geeksforgeeks.org/problems/largest-bst/1

public class LargestBSTSubTree{
	static TreeNode prev = null;
	static int largest = 1;
	// Return the size of the largest sub-tree which is also a BST
	static int largestBst(TreeNode root)
	{
		// Write your code here
		largest = 1;
		helper(root);
		return largest;


	}

	static void helper(TreeNode root)
	{
		if(root == null) return;

		prev = null;
		if(isBST(root))
		{
			largest = Math.max(largest , countTreeNode(root));
			return;
		}
		helper(root.left);
		helper(root.right);
	}

	static boolean isBST(TreeNode root)
	{
		if(root == null) return true;

		boolean left = isBST(root.left);
		if(prev != null && prev.val>=root.val) return false;
		else prev = root;
		boolean right = isBST(root.right);

		return left && right;
	}

	static int countTreeNode(TreeNode root)
	{
		if(root == null) return 0;

		int left = countTreeNode(root.left);
		int right = countTreeNode(root.right);

		return 1+left+right;
	}

}