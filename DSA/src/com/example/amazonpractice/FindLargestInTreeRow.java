package com.example.amazonpractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

public class FindLargestInTreeRow {
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if(root == null) return list;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while(! queue.isEmpty())
		{
			int size = queue.size();
			int max = Integer.MIN_VALUE;
			for(int i=0;i<size;i++)
			{
				TreeNode curr = queue.poll();
				max = Math.max(max , curr.val);
				if(curr.left != null) queue.offer(curr.left);
				if(curr.right != null) queue.offer(curr.right);
			}
			list.add(max);
		}

		return list;
	}
}