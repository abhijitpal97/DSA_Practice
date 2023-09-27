package com.example.amazonpractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/

public class MaxLevelSumBinaryTree {
	public int maxLevelSum(TreeNode root) {
		if(root == null) return -1;
		int maxSum = Integer.MIN_VALUE;
		int ans = 1;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int level = 1;

		while(! queue.isEmpty())
		{
			int size = queue.size();
			int sum = 0;
			for(int i=0;i<size;i++)
			{
				TreeNode curr =queue.poll();
				sum +=curr.val;
				if(curr.left != null)
				{
					queue.offer(curr.left);

				}
				if(curr.right != null)
				{
					queue.offer(curr.right);

				}
			}

			if(sum>maxSum) 
			{
				ans = level;
				maxSum=sum;
			}
			level++;
		}


		return ans;



	}
}