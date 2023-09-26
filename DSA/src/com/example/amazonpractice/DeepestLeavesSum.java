package com.example.amazonpractice;

import java.util.LinkedList;
import java.util.Queue;

import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/deepest-leaves-sum/description/

public class DeepestLeavesSum {
	public int deepestLeavesSum(TreeNode root) {
		if(root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		int sum =0;
		queue.offer(root);

		while(!queue.isEmpty())
		{
			sum = 0;
			int size = queue.size();
			for(int i=0;i<size;i++)
			{
				TreeNode node = queue.poll();
				sum +=node.val;

				if(node.left != null) queue.offer(node.left);
				if(node.right != null) queue.offer(node.right);
			}
		}

		return sum;
	}
}