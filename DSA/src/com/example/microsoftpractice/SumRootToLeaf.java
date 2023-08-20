package com.example.microsoftpractice;

import com.example.datastructure.skeleton.TreeNode;

public class SumRootToLeaf {
	int sum = 0;
	public int sumNumbers(TreeNode root) {
		sum = 0;
		if(root == null) return 0;
		function(root , 0);
		return sum;
	}

	void function(TreeNode node, int curr)
	{
		if(node == null) return;
		if(isLeaf(node))
		{
			curr = curr*10 + node.val;
			sum += curr;
			return;
		}

		curr = curr*10 + node.val;
		function(node.left , curr);
		function(node.right , curr);
	}

	boolean isLeaf(TreeNode node)
	{
		if(node.left == null && node.right == null) return true;
		return false;
	}
}