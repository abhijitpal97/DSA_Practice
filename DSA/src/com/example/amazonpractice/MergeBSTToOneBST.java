package com.example.amazonpractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/merge-bsts-to-create-single-bst/description/

public class MergeBSTToOneBST {
	public TreeNode canMerge(List<TreeNode> trees) {
		List<Integer> list = new ArrayList<>();

		for(TreeNode t1 : trees)
		{
			convertTree(t1,list);
		}
		Collections.sort(list);
		return generateTree(list , 0 , list.size()-1);
	}

	void convertTree(TreeNode tree , List<Integer> list)
	{
		if(tree == null) return ;

		list.add(tree.val);
		convertTree(tree.left , list);
		convertTree(tree.right , list);
	}

	TreeNode generateTree(List<Integer> list , int start , int end)
	{
		if(start>end) return null;

		int mid = start + (end-start)/2;
		TreeNode root = new TreeNode(mid);
		root.left = generateTree(list , start , mid-1);
		root.right = generateTree(list , mid+1 , end);

		return root;
	}
}