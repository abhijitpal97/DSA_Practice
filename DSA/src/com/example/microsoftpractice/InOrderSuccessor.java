package com.example.microsoftpractice;

import com.example.datastructure.skeleton.TreeNode;

// https://practice.geeksforgeeks.org/problems/inorder-successor-in-bst/1

public class InOrderSuccessor
{
	// returns the inorder successor of the Node x in BST (rooted at 'root')
	public TreeNode inorderSuccessor(TreeNode root,TreeNode x)
	{
		//add code here.
		TreeNode success = null;
		while(root != null)
		{
			if(x.val>=root.val) root = root.right;
			else
			{
				success = root;
				root = root.left;
			}
		}

		return success;
	}


}