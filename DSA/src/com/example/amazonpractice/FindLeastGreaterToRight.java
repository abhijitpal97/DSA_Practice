package com.example.amazonpractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

public class FindLeastGreaterToRight {
	public static ArrayList<Integer> findLeastGreater(int n, int[] arr) {
		// code here
		ArrayList<Integer> list = new ArrayList<>();
		list.add(-1);
		TreeNode root = new TreeNode(arr[n-1]);

		for(int i = n-2; i>=0;i--)
		{
			int x = addInBST(root , arr[i]);
			list.add(0,x);
		}

		return list;
	}

	static int addInBST(TreeNode root , int key)
	{
		int success = successor(root , key);
		TreeNode curr = root;
		while(true)
		{
			if(curr.val<key)
			{
				if(curr.right != null) curr=curr.right;
				else
				{
					curr.right = new TreeNode(key);
					break;
				}
			}
			else
			{
				if(curr.left != null) curr=curr.left;
				else
				{
					curr.left = new TreeNode(key);
					break;
				}
			}
		}

		return success;
	}

	static int successor(TreeNode root , int key)
	{
		int success = -1;
		while(root !=null)
		{
			if(key>=root.val) root=root.right;
			else
			{
				success = root.val;
				root=root.left;
			}
		}
		return success;
	}
}
