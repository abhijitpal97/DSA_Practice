package com.example.microsoftpractice;

import java.util.*;

import com.example.datastructure.skeleton.LinkedListNode;
import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/

public class SortedListToBST {
	public TreeNode sortedListToBST(LinkedListNode head) {
		if(head == null) return null;
		if(head.next == null) return new TreeNode(head.val);
		List<Integer> list = new ArrayList<>();
		while(head != null)
		{
			list.add(head.val);
			head = head.next;
		}

		return generateTree(list , 0 , list.size()-1);
	}

	TreeNode generateTree(List<Integer> list , int start , int end)
	{
		if(start>end) return null;

		int mid = start+(end-start)/2;
		TreeNode root = new TreeNode(list.get(mid));
		root.left = generateTree(list , start , mid-1);
		root.right = generateTree(list , mid+1 , end);

		return root;
	}


}