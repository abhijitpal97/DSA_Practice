package com.example.microsoftpractice;

import java.util.*;

import com.example.datastructure.skeleton.LinkedListNode;

// https://leetcode.com/problems/merge-k-sorted-lists/description/

public class MergeKList {
	public LinkedListNode mergeKLists(LinkedListNode[] lists) {
		Queue<Integer> pq = new PriorityQueue<>();

		for(LinkedListNode l1 : lists)
		{
			while(l1 !=null)
			{
				pq.offer(l1.val);
				l1 = l1.next;
			}
		}
		if(pq.isEmpty()) return null;
		LinkedListNode node = new LinkedListNode(pq.poll());
		LinkedListNode temp = node;
		while(! pq.isEmpty())
		{
			temp.next = new LinkedListNode(pq.poll());
			temp = temp.next;
		}

		return node;

	}
}