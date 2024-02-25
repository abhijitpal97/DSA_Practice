package com.example.leetCode75;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/path-sum-iii/

public class PathSum3 {
	int count = 0;
	public int pathSum(TreeNode root, int targetSum) {
		count = 0;
		Map<Long,Long> map = new HashMap<>();
		helper(root , targetSum , 0L , map);
		return count;
	}

	void helper(TreeNode root , int target , long sum , Map<Long,Long> map)
	{
		if(root == null) return;

		sum += root.val;

		if(sum == target) count++;

		if(map.containsKey(sum-target)) count += map.get(sum-target);

		map.put(sum , map.getOrDefault(sum , 0L)+1);
		helper(root.left,target , sum, map);
		helper(root.right,target , sum, map);
		map.put(sum , map.getOrDefault(sum , 0L)-1);
	}
}