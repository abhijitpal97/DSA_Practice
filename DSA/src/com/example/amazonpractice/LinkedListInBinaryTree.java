package com.example.amazonpractice;

import com.example.datastructure.skeleton.LinkedListNode;
import com.example.datastructure.skeleton.TreeNode;

public class LinkedListInBinaryTree {
	public boolean isSubPath(LinkedListNode head, TreeNode root) {
		if(head == null && root == null) return true;
		if(head == null) return false;
		if(root == null) return false;

		return helper(head , root) || isSubPath(head , root.left) || isSubPath(head , root.right);

	}

	boolean helper(LinkedListNode head, TreeNode root)
	{
		if(head == null) return true;
		if(root == null) return false;

		return head.val==root.val && (helper(head.next , root.left) || helper(head.next , root.right));
	}
}