package com.example.microsoftpractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1

class VerticalPair
{
	TreeNode node;
	int level;

	VerticalPair(TreeNode node , int level)
	{
		this.node=node;
		this.level=level;
	}
}

public class VerticalTraversalofBinaryTree {
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		Map<Integer,List<Integer>> map = new TreeMap<>();
		List<List<Integer>> result = new ArrayList<>();
		Queue<VerticalPair> queue = new LinkedList<>();
		queue.offer(new VerticalPair(root , 0));
		map.put(0 , new ArrayList<>(Arrays.asList(root.val)));

		while(! queue.isEmpty())
		{
			VerticalPair p1 = queue.poll();
			TreeNode curr = p1.node;
			int index = p1.level;

			if(curr.left != null)
			{
				queue.offer(new VerticalPair(curr.left , index-1));
				if(map.containsKey(index-1)) map.get(index-1).add(curr.left.val);
				else map.put(index-1 , new ArrayList<>(Arrays.asList(curr.left.val)));
			}

			if(curr.right != null)
			{
				queue.offer(new VerticalPair(curr.right , index+1));
				if(map.containsKey(index+1)) map.get(index+1).add(curr.right.val);
				else map.put(index+1 , new ArrayList<>(Arrays.asList(curr.right.val)));
			}
		}

		for(Map.Entry<Integer,List<Integer>> m1 : map.entrySet()) 
		{
			result.add(m1.getValue());
		}

		return result;
	}

	// Vertical - AlterNative

	static ArrayList <Integer> verticalOrder(TreeNode root)
	{
		// add your code here
		ArrayList<Integer> list = new ArrayList<>();
		if(root == null) return list;
		Queue<VerticalPair> queue = new LinkedList<>();
		Map<Integer , ArrayList<Integer>> map = new TreeMap<>();
		queue.offer(new VerticalPair(root,0));

		while(! queue.isEmpty())
		{
			VerticalPair pair=  queue.poll();
			TreeNode node = pair.node;
			int level = pair.level;
			ArrayList<Integer> temp = new ArrayList<>();

			if(!map.containsKey(level))
			{
				temp.add(node.val);
				map.put(level , temp);
			}
			else
			{
				temp = map.get(level);
				temp.add(node.val);
				map.put(level , temp);

			}

			if(node.left != null) queue.offer(new VerticalPair(node.left , level-1));
			if(node.right != null) queue.offer(new VerticalPair(node.right ,level+1));
		}

		for(Map.Entry<Integer , ArrayList<Integer>> m1 : map.entrySet())
		{
			for(int i : m1.getValue()) list.add(i);
		}

		return list;
	}
}