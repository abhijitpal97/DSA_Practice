package com.example.leetCode75;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/binary-tree-right-side-view/

public class BinaryTreeRightView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if(root == null) return list;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while(! queue.isEmpty())
		{
			int size = queue.size();
			boolean isRight = false;

			for(int i=0;i<size;i++)
			{
				TreeNode curr = queue.poll();
				if(! isRight)
				{
					list.add(curr.val);
					isRight = true;
				}

				if(curr.right != null) queue.offer(curr.right);
				if(curr.left != null) queue.offer(curr.left);
			}
		}
		return list;
	}
}