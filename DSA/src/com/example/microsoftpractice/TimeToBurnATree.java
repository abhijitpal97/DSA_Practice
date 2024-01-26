package com.example.microsoftpractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
// https://www.geeksforgeeks.org/problems/burning-tree/1

public class TimeToBurnATree {
	public int amountOfTime(TreeNode root, int start) {
		Queue<TreeNode> targetQ = new LinkedList<>();
		Map<TreeNode,TreeNode> map = new HashMap<>();
		markAsParent(root,start,targetQ,map);
		Map<TreeNode,Boolean> isVisited = new HashMap<>();
		if(targetQ.isEmpty()) return -1;
		isVisited.put(targetQ.peek() , true);

		int time = 0;
		while(! targetQ.isEmpty())
		{
			int size = targetQ.size();

			for(int i=0;i<size;i++)
			{
				TreeNode curr = targetQ.poll();
				if(curr.left != null && ! isVisited.containsKey(curr.left))
				{
					isVisited.put(curr.left , true);
					targetQ.offer(curr.left);
				}
				if(curr.right != null && ! isVisited.containsKey(curr.right))
				{
					isVisited.put(curr.right , true);
					targetQ.offer(curr.right);
				}
				if(map.containsKey(curr) && ! isVisited.containsKey(map.get(curr)))
				{
					isVisited.put(map.get(curr) , true);
					targetQ.offer(map.get(curr));
				}
			}
			time++;
		}

		return time-1;
	}

	void markAsParent(TreeNode root , int start , Queue<TreeNode> targetQ , Map<TreeNode,TreeNode> map)
	{
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while(! queue.isEmpty())
		{
			TreeNode curr = queue.poll();
			if(curr.val == start) targetQ.offer(curr);

			if(curr.left !=null)
			{
				map.put(curr.left , curr);
				queue.offer(curr.left);
			}
			if(curr.right !=null)
			{
				map.put(curr.right , curr);
				queue.offer(curr.right);
			}
		}
	}
}