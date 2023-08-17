package com.example.microsoftpractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

public class CheckForCompleteTree {
	public boolean isCompleteTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		//int count =queue.size();
		boolean isNull = false;

		while(! queue.isEmpty())
		{
			TreeNode curr = queue.poll();
			if(curr == null) isNull = true;
			if(curr != null && isNull) return false;

			if(curr != null)
			{
				queue.offer(curr.left);
				queue.offer(curr.right);
			}
			//count--;

			//if(count ==0) count = queue.size();
		}

		return true;
	}
}