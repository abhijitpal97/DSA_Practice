package com.example.googlepractice;

import com.example.datastructure.skeleton.TreeNode;

public class BTTODLL
{
	//Function to convert binary tree to doubly linked list and return it.
	TreeNode prev = null;
	TreeNode head = null;
	TreeNode bToDLL(TreeNode root)
	{
		//  Your code here	

		if(root == null) return null;
		bToDLL(root.left);

		if(head == null) 
		{
			head = root;
			prev = root;
		}
		else
		{
			prev.right = root;
			root.left = prev;
			prev = root;
		}

		bToDLL(root.right);

		return head;
	}
}