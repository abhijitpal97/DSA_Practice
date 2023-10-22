package com.example.gspractice;

import com.example.datastructure.skeleton.TreeNode;


// https://practice.geeksforgeeks.org/problems/sum-tree/1

public class SumTree
{
	int flag = 1;
	boolean isSumTree(TreeNode root)
	{
		// Your code here
		if(root == null) return true;
		if(root.left == null && root.right == null) return true;

		sumTreeHelper(root);

		return (flag==1);
	}


	int sumTreeHelper(TreeNode root)
	{
		if(root == null) return 0;
		if(root.left==null && root.right==null) return root.val;
		int left = sumTreeHelper(root.left);
		int right = sumTreeHelper(root.right);

		if(left+right != root.val) flag = 0;

		return left+right+root.val;
	}

}