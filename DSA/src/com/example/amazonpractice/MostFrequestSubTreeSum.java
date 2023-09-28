package com.example.amazonpractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/most-frequent-subtree-sum/

public class MostFrequestSubTreeSum {
	public int[] findFrequentTreeSum(TreeNode root) {
		Map<Integer,Integer> map = new HashMap<>();
		function(map , root);
		Queue<int[]> queue = new PriorityQueue<>((a,b) -> b[1] - a[1]);

		for(Map.Entry<Integer,Integer> m1 : map.entrySet())
		{
			queue.offer(new int[]{m1.getKey() , m1.getValue()});
		}
		List<Integer> list = new ArrayList<>();
		int max = queue.peek()[1];
		while(!queue.isEmpty() &&  queue.peek()[1] == max)
		{
			list.add(queue.poll()[0]);
		}

		int[] result = new int[list.size()];
		for(int i=0;i<list.size();i++) result[i] = list.get(i);

		return result;

	}

	int function(Map<Integer,Integer> map , TreeNode root)
	{
		if(root == null) return 0;

		int left = function(map , root.left);
		int right = function(map , root.right);

		int sum = left+right+root.val;

		map.put(sum , map.getOrDefault(sum , 0)+1);

		return sum;

	}
}