package com.example.uncategorized;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/description/

public class PseudoPalindromicPath {
	int count = 0;
	public int pseudoPalindromicPaths (TreeNode root) {
		count = 0;
		Map<Integer,Integer> map = new HashMap<>();
		getRootToLeaf(root , map);
		return count;
	}

	boolean getRootToLeaf(TreeNode node , Map<Integer,Integer> map)
	{
		if(node == null)
		{
			return true ;
		}

		int curr = node.val;
		map.put(curr , map.getOrDefault(curr , 0)+1);

		boolean left = getRootToLeaf(node.left , map);
		boolean right = getRootToLeaf(node.right , map);

		if(left && right)
		{
			if(isPalindromic(map)) count++;
		}
		map.put(curr , map.get(curr)-1);
		if(map.get(curr) == 0) map.remove(curr);

		return false;
	}

	boolean isPalindromic(Map<Integer,Integer> map)
	{
		//System.out.println(map);
		int odd = 0;
		for(Map.Entry<Integer,Integer> m1 : map.entrySet())
		{
			if(m1.getValue()%2==0) continue;
			odd++;
		}
		return odd<=1;
	}

}