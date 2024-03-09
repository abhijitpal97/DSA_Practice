package com.example.leetCode75;

import com.example.datastructure.skeleton.LinkedListNode;

// https://leetcode.com/problems/reverse-linked-list/

public class ReverseLinkedList {
	public LinkedListNode reverseList(LinkedListNode head) {
		LinkedListNode prev = null;
		LinkedListNode curr = head;
		LinkedListNode temp = null;

		while(curr != null)
		{
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}

		return prev;
	}
}