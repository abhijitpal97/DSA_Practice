package com.example.amazonpractice;

import com.example.datastructure.skeleton.TreeNode;

public class LeavesOneLevelApart {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static boolean areLeavesOneLevelApart(TreeNode root) {
		// Write your code here.
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		traverse(root , 0);
		if(max-min>1) return false;
		return true;
	}

	static void traverse(TreeNode root , int level)
	{
		if(root == null) return;

		if(isLeaf(root)) 
		{
			max = Math.max(max , level);
			min = Math.min(min , level);
			return;
		}

		traverse(root.left , level+1);
		traverse(root.right, level+1);
	}

	static boolean isLeaf(TreeNode root)
	{
		if(root.left == null && root.right == null) return true;
		return false;
	}
}