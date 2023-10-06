package com.example.microsoftpractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/maximum-width-of-binary-tree/

class WidthPair{
	TreeNode root;
	int index;

	WidthPair(TreeNode root,int index){
		this.root=root;
		this.index=index;
	}
}


public class MaxWidthBinaryTree {
	public int widthOfBinaryTree(TreeNode root) {
		if(root == null) return 0;
		Queue<WidthPair> queue = new LinkedList<>();
		int ans = 0;
		queue.offer(new WidthPair(root , 0));

		while(! queue.isEmpty())
		{
			int start = 0;
			int end = 0;
			int size = queue.size();
			for(int i = 0 ; i<size;i++)
			{
				WidthPair curr = queue.poll();
				int index = curr.index;
				if(i == 0) start = index;
				if(i == size-1) end = index;
				if(curr.root.left != null) queue.offer(new WidthPair(curr.root.left , 2*index));
				if(curr.root.right != null) queue.offer(new WidthPair(curr.root.right , 2*index + 1));
			}

			ans = Math.max(ans , end-start+1);
		}

		return ans;
	}
}