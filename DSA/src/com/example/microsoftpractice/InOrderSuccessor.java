package com.example.microsoftpractice;

import com.example.datastructure.skeleton.TreeNode;

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