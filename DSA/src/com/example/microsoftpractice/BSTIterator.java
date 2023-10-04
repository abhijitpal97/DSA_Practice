package com.example.microsoftpractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/binary-search-tree-iterator/description/

class BSTIterator {
	Queue<Integer> queue;
	public BSTIterator(TreeNode root) {
		queue = new LinkedList<>();
		iterateTree(root);
	}

	public int next() {
		if(!queue.isEmpty()) return queue.poll();
		return -1;
	}

	public boolean hasNext() {
		if(! queue.isEmpty()) return true;
		return false;
	}

	void iterateTree(TreeNode root)
	{
		if(root == null) return ;
		iterateTree(root.left);
		queue.offer(root.val);
		iterateTree(root.right);
	}
}