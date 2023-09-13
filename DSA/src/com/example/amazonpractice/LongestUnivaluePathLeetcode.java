package com.example.amazonpractice;

import com.example.datastructure.skeleton.TreeNode;

public class LongestUnivaluePathLeetcode {
	int max = 0;
	public int longestUnivaluePath(TreeNode root) {
		if(root == null ) return 0;
		max = 0;
		function(root);

		return max-1;
	}

	int[] function(TreeNode root)
	{
		if(root == null) return new int[]{0,0};

		int[] currL = function(root.left);
		int[] currR = function(root.right);

		int leftC = (currL[0] == root.val)?currL[1]:0;
		int rightC = (currR[0] == root.val)?currR[1]:0;

		max = Math.max(max , leftC+rightC+1);

		return new int[]{root.val , 1+Math.max(leftC , rightC)};
	}
}