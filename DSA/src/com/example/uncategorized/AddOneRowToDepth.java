package com.example.uncategorized;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/add-one-row-to-tree/

public class AddOneRowToDepth {
	public TreeNode addOneRow(TreeNode root, int val, int depth) {
		if(depth == 1) return new TreeNode(val , root , null);


		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int currDep = 1;

		while(! queue.isEmpty())
		{
			int size = queue.size();

			for(int i=0;i<size;i++)
			{
				if(currDep+1 == depth)
				{
					for(int j=0;j<size;j++)
					{
						TreeNode curr = queue.poll();
						curr.left = new TreeNode(val , curr.left , null);
						curr.right = new TreeNode(val , null , curr.right);
					}
					break;
				}
				else
				{
					TreeNode curr = queue.poll();
					if(curr.left != null) queue.offer(curr.left);
					if(curr.right != null) queue.offer(curr.right);                    
				}
			}
			currDep++;
		}

		return root;
	}
}