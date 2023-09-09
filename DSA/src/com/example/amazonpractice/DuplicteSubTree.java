package com.example.amazonpractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

public class DuplicteSubTree{

	public List<TreeNode> printAllDups(TreeNode root)
	{
		//code here
		Map<String,Integer> ans = new HashMap<>();
		List<TreeNode> list = new ArrayList<>();
		calculateDups(root , ans , list);
		Collections.sort(list, (tree1, tree2) -> tree1.val-tree2.val);
		return list;
	}

	public String calculateDups(TreeNode root, Map<String,Integer> ans , List<TreeNode> list )
	{
		if(root == null) return "#";

		String left = calculateDups(root.left , ans , list);
		String right = calculateDups(root.right , ans , list);

		String s = left+String.valueOf(root.val)+right;
		ans.put(s,ans.getOrDefault(s , 0)+1);
		if(ans.get(s) == 2)
		{
			list.add(root);
		}
		return s;
	}

}