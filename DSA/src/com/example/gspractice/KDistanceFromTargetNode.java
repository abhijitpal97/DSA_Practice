package com.example.gspractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/

public class KDistanceFromTargetNode {
	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		Map<TreeNode,TreeNode> map = new HashMap<>();
		Queue<TreeNode> targetQueue = new LinkedList<>();
		markParent(map , targetQueue , target , root);
		Map<TreeNode,Boolean> isVisited = new HashMap<>();
		isVisited.put(targetQueue.peek() , true);

		while(k != 0)
		{
			int size = targetQueue.size();

			for(int i = 0; i<size ; i++)
			{
				TreeNode curr = targetQueue.poll();

				if(curr.left != null && ! isVisited.containsKey(curr.left))
				{
					targetQueue.offer(curr.left);
					isVisited.put(curr.left , true);
				}
				if(curr.right != null && ! isVisited.containsKey(curr.right))
				{
					targetQueue.offer(curr.right);
					isVisited.put(curr.right , true);
				}
				if(map.containsKey(curr) && ! isVisited.containsKey(map.get(curr)))
				{
					targetQueue.offer(map.get(curr));
					isVisited.put(map.get(curr) , true);
				}
			}
			k--;
		}

		List<Integer> list = new ArrayList<>();

		while(! targetQueue.isEmpty()) list.add(targetQueue.poll().val);

		return list;

	}

	void markParent(Map<TreeNode,TreeNode> map , Queue<TreeNode> targetQueue , TreeNode target , TreeNode root)
	{
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while(! queue.isEmpty())
		{
			TreeNode curr = queue.poll();
			if(curr.val == target.val) targetQueue.offer(curr);
			if(curr.left != null)
			{
				map.put(curr.left , curr);
				queue.offer(curr.left);
			}
			if(curr.right != null)
			{
				map.put(curr.right , curr);
				queue.offer(curr.right);
			}
		}
	}
}