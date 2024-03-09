package com.example.leetCode75;

import com.example.datastructure.skeleton.LinkedListNode;

// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

public class DeleteMiddleNode {
	public LinkedListNode deleteMiddle(LinkedListNode head) {

		LinkedListNode prev = null;
		LinkedListNode slow = head;
		LinkedListNode fast = head;

		while(fast != null && fast.next != null)
		{
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		LinkedListNode currNext = slow.next;
		if(prev == null) return null;

		prev.next = currNext;

		return head;

	}
}