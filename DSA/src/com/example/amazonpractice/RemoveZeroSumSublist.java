package com.example.amazonpractice;

import java.util.*;

import com.example.datastructure.skeleton.LinkedListNode;

// https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list

public class RemoveZeroSumSublist {
	public LinkedListNode removeZeroSumSublists(LinkedListNode head) {
		Map<Integer,LinkedListNode> map = new HashMap<>();
		LinkedListNode result = new LinkedListNode(0);
		result.next = head;
		LinkedListNode temp = result;
		int sum = 0;

		while(temp != null)
		{
			sum += temp.val;
			if(map.containsKey(sum))
			{
				temp = map.get(sum).next;
				int curr = sum+temp.val;

				while(curr != sum)
				{
					map.remove(curr);
					temp = temp.next;
					curr += temp.val;
				}
				map.get(sum).next = temp.next;
			}
			else map.put(sum , temp);

			temp = temp.next;
		}

		return result.next;

	}
}