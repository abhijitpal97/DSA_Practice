package com.example.amazonpractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

public class DiagonalTreeTraversal
{
	public static void main(String[] args)
	{
		TreeNode TreeNode = new TreeNode(8);
		TreeNode.left = new TreeNode(10);
		TreeNode.right = new TreeNode(3);

		TreeNode.left.left = new TreeNode(14);
		TreeNode.left.left.right = new TreeNode(13);

		TreeNode.right.left = new TreeNode(6);
		TreeNode.right.right = new TreeNode(1);

		TreeNode.right.left.left = new TreeNode(7);
		TreeNode.right.left.right = new TreeNode(4);

		ArrayList<Integer> res = diagonal(TreeNode);
		System.out.println(res);
	}
	public static ArrayList<Integer> diagonal(TreeNode root)
	{
		//add your code here.
		ArrayList<Integer> list = new ArrayList<>();
		if(root == null) return list;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(! queue.isEmpty())
		{
			TreeNode curr = queue.poll();
			while(curr != null)
			{
				list.add(curr.val);
				if(curr.left != null) queue.offer(curr.left);
				curr = curr.right;
			}
		}
		return list;
	}
}