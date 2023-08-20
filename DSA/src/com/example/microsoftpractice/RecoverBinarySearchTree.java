package com.example.microsoftpractice;

import com.example.datastructure.skeleton.TreeNode;

public class RecoverBinarySearchTree {
	TreeNode prev;
	TreeNode first;
	TreeNode second;
	public void recoverTree(TreeNode root) {
		prev = null;
		first = null;
		second = null;

		inOrder(root);

		int temp = first.val;
		first.val = second.val;
		second.val = temp;        
	}

	void inOrder(TreeNode node)
	{
		if(node == null) return ;

		inOrder(node.left);
		if(prev != null && prev.val > node.val)
		{
			if(first == null) first = prev;
			second = node;
		}
		prev = node;
		inOrder(node.right);
	}
}