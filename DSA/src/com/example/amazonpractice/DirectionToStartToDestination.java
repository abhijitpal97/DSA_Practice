package com.example.amazonpractice;

import java.util.*;
import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/

class DirectionPair
{
	TreeNode node;
	String path;

	DirectionPair(TreeNode node , String path)
	{
		this.node = node;
		this.path = path;
	}
}

public class DirectionToStartToDestination {
	public static void main(String[] args)
	{
		TreeNode tree = new TreeNode(5);
		tree.left=new TreeNode(1);
		tree.right=new TreeNode(2);
		tree.left.left=new TreeNode(3);
		tree.right.left=new TreeNode(6);
		tree.right.right=new TreeNode(4);
		
		String str = getDirections(tree, 3, 6);
		System.out.println(str);
	}
	public static String getDirections(TreeNode root, int startValue, int destValue) {
		Map<TreeNode,TreeNode> map = new HashMap<>();
		Queue<DirectionPair> queue = new LinkedList<>();
		getParent(root,map,startValue,queue);
		Map<TreeNode,Boolean> isVisited = new HashMap<>();
		isVisited.put(queue.peek().node , true);
		while(! queue.isEmpty())
		{
			DirectionPair DirectionPair = queue.poll();
			TreeNode curr = DirectionPair.node;
			String path = DirectionPair.path;

			if(curr.val == destValue) return path;

			if(curr.left != null && ! isVisited.containsKey(curr.left))
			{
				queue.offer(new DirectionPair(curr.left , path+"L"));
				isVisited.put(curr.left , true);
			}

			if(curr.right != null && ! isVisited.containsKey(curr.right))
			{
				queue.offer(new DirectionPair(curr.right , path+"R"));
				isVisited.put(curr.right , true);
			}

			if(map.containsKey(curr) && !isVisited.containsKey(map.get(curr)))
			{
				queue.offer(new DirectionPair(map.get(curr) , path+"U"));
				isVisited.put(map.get(curr) , true);
			}
		}

		return "";

	}

	static void getParent(TreeNode root , Map<TreeNode,TreeNode> map , int start , Queue<DirectionPair> startQ)
	{
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(! queue.isEmpty())
		{
			TreeNode curr = queue.poll();
			if(curr.val == start) startQ.offer(new DirectionPair(curr , ""));
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