package com.example.microsoftpractice;

import com.example.datastructure.skeleton.TreeNode;

public class DeleteNodeInBST{
	// Function to delete a TreeNode from BST.
	public static TreeNode deleteTreeNode(TreeNode root, int X) {
		// code here.
		if(root == null) return null;

		if(X>root.val) root.right = deleteTreeNode(root.right , X);
		else if(X<root.val) root.left = deleteTreeNode(root.left , X);
		else
		{
			if(root.left == null) return root.right;
			if(root.right == null) return root.left;
			root.val = getMin(root.right);
			root.right = deleteTreeNode(root.right , root.val);
		}

		return root;
	}

	static int getMin(TreeNode root)
	{
		int minV = root.val;
		while(root.left !=null)
		{
			minV = root.left.val;
			root = root.left;
		}

		return minV;
	}
}

