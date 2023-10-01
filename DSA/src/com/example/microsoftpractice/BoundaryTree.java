package com.example.microsoftpractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1

public class BoundaryTree
{
	ArrayList <Integer> boundary(TreeNode TreeNode)
	{
		ArrayList<Integer> list = new ArrayList<>();
		if(TreeNode == null) return list;

		if(! isLeaf(TreeNode)) list.add(TreeNode.val);

		leftNonLeaf(TreeNode,list);
		traverseLeaf(TreeNode,list);
		rightNonLeaf(TreeNode,list);

		return list;
	}

	boolean isLeaf(TreeNode TreeNode)
	{
		if(TreeNode.left == null && TreeNode.right == null) return true;
		return false;
	}

	void traverseLeaf(TreeNode TreeNode , ArrayList<Integer> list)
	{
		if(TreeNode == null) return;

		if(isLeaf(TreeNode)) 
		{
			list.add(TreeNode.val);
			return;
		}

		traverseLeaf(TreeNode.left,list);
		traverseLeaf(TreeNode.right,list);
	}

	public void leftNonLeaf(TreeNode TreeNode , ArrayList<Integer> list)
	{
		if(TreeNode == null) return ;

		TreeNode curr = TreeNode.left;
		while(curr != null)
		{
			if(! isLeaf(curr)) list.add(curr.val);
			if(curr.left != null) curr=curr.left;
			else curr = curr.right;
		}
	}

	public void rightNonLeaf(TreeNode TreeNode , ArrayList<Integer> list)
	{
		List<Integer> temp = new ArrayList<>();
		if(TreeNode == null) return ;

		TreeNode curr = TreeNode.right;
		while(curr != null)
		{
			if(! isLeaf(curr)) temp.add(curr.val);
			if(curr.right != null) curr=curr.right;
			else curr = curr.left;
		}

		Collections.reverse(temp);
		list.addAll(temp);
	}
}
