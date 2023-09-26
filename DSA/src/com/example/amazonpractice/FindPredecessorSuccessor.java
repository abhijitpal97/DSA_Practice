package com.example.amazonpractice;

import com.example.datastructure.skeleton.TreeNode;

// https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1

public class FindPredecessorSuccessor {


	//Function to check whether a Binary Tree is BST or not.
	public static void findPreSuc(TreeNode root, int key)
	{
		System.out.println(findPreDecessor(root , key) + " " + findSuccessor(root , key));

	}

	static int findSuccessor(TreeNode root, int key)
	{
		int success = -1;
		while(root != null)
		{
			if(key>= root.val)
			{
				root = root.right;
			}
			else
			{
				success = root.val;
				root = root.left;
			}
		}

		return success;
	}


	static int findPreDecessor(TreeNode root, int key)
	{
		int predecessor = -1;
		while(root != null)
		{
			if(key<= root.val)
			{
				root = root.left;
			}
			else
			{
				predecessor = root.val;
				root = root.right;
			}
		}

		return predecessor;
	}

}

