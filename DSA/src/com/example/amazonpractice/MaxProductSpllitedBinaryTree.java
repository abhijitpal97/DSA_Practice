package com.example.amazonpractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/

public class MaxProductSpllitedBinaryTree {
	public int maxProduct(TreeNode root) {
		List<Long> list = new ArrayList<>();
		long total = helper(root , list);
		long max = 0;

		for(long s : list)
		{
			long p = s*(total-s);
			max = Math.max(max , p);
		}

		return (int)(max%1000000007);
	}

	long helper(TreeNode root , List<Long> sums)
	{
		if(root == null) return 0;

		long left = helper(root.left , sums);
		long right = helper(root.right , sums);

		long sum = root.val+left+right;
		sums.add(sum);
		return sum;
	}
}