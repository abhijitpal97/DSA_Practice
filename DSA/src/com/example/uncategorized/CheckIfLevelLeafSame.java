package com.example.uncategorized;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://www.codingninjas.com/studio/problems/level-leaf_3210614?leftPanelTab=0

public class CheckIfLevelLeafSame{

	public static void main(String[] args)
	{
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(4);
		node.left.left = new TreeNode(3);
		node.right.left = new TreeNode(5);
		node.right.right = new TreeNode(6);
		boolean res = checkLeafLevel(node);
		System.out.println(res);
	}

	static int level = Integer.MIN_VALUE;        
	static boolean checkLeafLevel(TreeNode root){
		if(root == null) return true;
		if(root.left != null && root.right != null)
		{
			if(height(root.left) != height(root.right)) return false;
		}

		return checkLeafLevel(root.left) && checkLeafLevel(root.right);
	} 

	static int height(TreeNode root)
	{
		if(root == null) return 0;

		int l = height(root.left);
		int r = height(root.right);

		return Math.max(l , r) +1;
	}

	// Alternate
	static Set<Integer> set;
	public static int levelLeaf(TreeNode root) {
		// Write your code here.
		set = new HashSet<>();
		function(root , 0);
		//System.out.println(set);
		return set.size()==1?1:0;

	}

	static void function(TreeNode node , int level)
	{
		if(node == null) return;
		if(isLeaf(node)) set.add(level);

		function(node.left , level+1);
		function(node.right , level+1);
	}

	static boolean isLeaf(TreeNode node)
	{
		return node.left==null && node.right==null;
	}
}