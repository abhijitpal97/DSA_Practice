package com.example.amazonpractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/delete-nodes-and-return-forest/

public class DeleteAndReturnForest {
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		List<TreeNode> forest = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		for(int i : to_delete) set.add(i);

		TreeNode curr = traverse(forest , root , set);

		if(curr != null) forest.add(curr);

		return forest;
	}

	TreeNode traverse(List<TreeNode> forest , TreeNode root , Set<Integer> set)
	{
		if(root == null) return null;

		root.left = traverse(forest , root.left , set);
		root.right = traverse(forest , root.right , set);

		if(set.contains(root.val))
		{
			if(root.left != null)
			{
				forest.add(root.left);
			}

			if(root.right != null)
			{
				forest.add(root.right);
			}

			return null;
		}

		return root;
	}
}