package com.example.microsoftpractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

public class NArrayLevelOrder {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		if(root == null) return result;
		int children = root.children.size();

		if(children == 0) 
		{
			list.add(root.val);
			result.add(list);
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int count = 1 ;
		int local = 0;
		while(! queue.isEmpty())
		{
			TreeNode curr = queue.poll(); //3 2
			list.add(curr.val); // 3 2
			count --; // 1
			for(TreeNode temp : curr.children)
			{
				queue.add(temp);
				local++; 
			} 
			if(count == 0) 
			{
				result.add(list); // [1]
				list= new ArrayList<>();
				count = local; //3
				local = 0;
			}

		}

		return result;
	}
}