package com.example.microsoftpractice;

import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/delete-node-in-a-bst/description/

public class DeleteNodeBST {
	public TreeNode deleteNode(TreeNode root, int key) {
		if(root == null) return null;
		if(root.val > key) root.left = deleteNode(root.left , key);
		else if(root.val < key) root.right = deleteNode(root.right , key);
		else
		{
			if(root.left == null) return root.right;
			else if(root.right == null) return root.left;
			else
			{
				int rightMin = getMin(root.right);
				root.val = rightMin;
				root.right = deleteNode(root.right, rightMin);
			}
		}

		return root;
	}

	int getMin(TreeNode root)
	{
		int min =Integer.MAX_VALUE;;
		while(root != null)
		{
			min = Math.min(min , root.val);
			root = root.left;
		}

		return min;
	}
}