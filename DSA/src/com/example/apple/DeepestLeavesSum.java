package com.example.apple;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/deepest-leaves-sum/description/

public class DeepestLeavesSum {
	public int deepestLeavesSum(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int sum = 0 ;
		while(! queue.isEmpty())
		{
			sum = 0;
			int size = queue.size();

			for(int i = 0 ; i<size ; i++)
			{
				TreeNode curr = queue.poll();
				sum += curr.val;

				if(curr.left != null) queue.offer(curr.left);
				if(curr.right != null) queue.offer(curr.right);
			}
		}

		return sum;

	}
}