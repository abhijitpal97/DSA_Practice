package com.example.amazonpractice;

import com.example.datastructure.skeleton.TreeNode;

// https://www.codingninjas.com/studio/problems/boundary-sum_790724

public class BoundarySum {
	static int sum = 0;

	public static void main(String[] args)
	{
		TreeNode node = new TreeNode(5);
		node.right = new TreeNode(6);

		int res = boundarySum(node);
		System.out.println(res);
	}

	public static int boundarySum(TreeNode root) {
		// Write your code here.
		sum = 0;
		if(root == null) return 0;

		if(isLeaf(root)) return root.val;

		leftNonLeaf(root);
		traverseLeaf(root);
		rightNonLeaf(root);


		return sum+root.val;
	}

	static boolean isLeaf(TreeNode node)
	{
		if(node.left == null && node.right == null) return true;
		return false;
	}

	static void traverseLeaf(TreeNode node)
	{
		if(node == null) return;

		if(isLeaf(node)) 
		{
			sum += node.val;
			return;
		}

		traverseLeaf(node.left);
		traverseLeaf(node.right);
	}

	static void leftNonLeaf(TreeNode node)
	{
		if(node == null) return ;

		TreeNode curr = node.left;
		while(curr != null)
		{
			if(! isLeaf(curr)) sum += curr.val;
			if(curr.left != null) curr=curr.left;
			else curr = curr.right;
		}
	}

	static void rightNonLeaf(TreeNode node)
	{
		if(node == null) return ;

		TreeNode curr = node.right;
		while(curr != null)
		{
			if(! isLeaf(curr)) sum += curr.val;
			if(curr.right != null) curr=curr.right;
			else curr = curr.left;
		}
	}

}