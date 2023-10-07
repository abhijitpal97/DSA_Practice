package com.example.microsoftpractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://practice.geeksforgeeks.org/problems/print-all-nodes-that-dont-have-sibling/1

public class NoSiblingLeaves
{
	ArrayList<Integer> noSibling(TreeNode TreeNode)
	{
		// code here
		ArrayList<Integer> list = new ArrayList<>();
		if(TreeNode == null) return list;
		helper(TreeNode , list);
		if(list.isEmpty()) list.add(-1);
		Collections.sort(list);
		return list;
	}

	void helper(TreeNode root , ArrayList<Integer> list)
	{
		if(root == null) return;
		if(root.left != null && root.right == null)
		{
			list.add(root.left.val);
		}
		else if(root.left == null && root.right != null) 
		{
			list.add(root.right.val);
		}

		helper(root.left , list);
		helper(root.right , list);

	}
}