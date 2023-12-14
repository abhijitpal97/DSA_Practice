package com.example.amazonpractice;
// https://leetcode.com/problems/binary-tree-paths/description/

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

public class BinaryTreePath {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<>();
		function(root , "" , list);
		return list;
	}

	void function(TreeNode root , String curr , List<String> list)
	{
		if(root == null) return;

		if(root.left == null && root.right == null)
		{
			String temp = curr+"->"+String.valueOf(root.val);
			list.add(temp.substring(2));
			return;
		}

		function(root.left , curr+"->"+String.valueOf(root.val) , list);
		function(root.right , curr+"->"+String.valueOf(root.val) , list);
	}
}