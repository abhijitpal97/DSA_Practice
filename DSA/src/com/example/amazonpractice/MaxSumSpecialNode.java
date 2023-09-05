package com.example.amazonpractice;

import com.example.datastructure.skeleton.TreeNode;

public class MaxSumSpecialNode
{
	int[] max = new int[1]; 
	int maxPathSum(TreeNode root)
	{ 
		// code here 
		if(root == null) return 0;
		if(root.left == null && root.right == null) return root.val;

		max[0] = Integer.MIN_VALUE;
		int res = function(root);

		if(root.left == null || root.right == null) return Math.max(max[0] , res);
		return max[0];
	} 

	int function(TreeNode root)
	{
		if(root == null) return 0;

		int l = function(root.left);
		int r = function(root.right);

		if(root.left == null) return r+root.val;
		if(root.right == null) return l+root.val;

		max[0] = Math.max(max[0] , root.val+l+r);

		return root.val+Math.max(l , r);
	}
}