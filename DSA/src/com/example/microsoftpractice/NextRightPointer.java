package com.example.microsoftpractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/

public class NextRightPointer {
	public TreeNode connect(TreeNode root) {
		if(root == null) return null;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while(! queue.isEmpty())
		{
			int size = queue.size();
			TreeNode prev = null;

			for(int i = 0 ; i<size;i++)
			{
				TreeNode curr = queue.poll();
				curr.next = prev;
				prev = curr;

				if(curr.right != null) queue.offer(curr.right);
				if(curr.left != null) queue.offer(curr.left);
			}
		}

		return root;
	}
}