package com.example.leetCode75;

import com.example.datastructure.skeleton.LinkedListNode;

// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/

public class MaximumTwinSum {
	public int pairSum(LinkedListNode head) {
		int max = 0;
		if(head == null) return max;

		LinkedListNode middle = getMiddle(head);
		LinkedListNode secondHalf = middle.next;
		middle.next = null;
		secondHalf = reverse(secondHalf);

		while(head != null)
		{
			int curr = head.val + secondHalf.val;
			max = Math.max(max , curr);
			head = head.next;
			secondHalf = secondHalf.next;
		}

		return max;
	}

	LinkedListNode reverse(LinkedListNode node)
	{
		LinkedListNode prev = null;
		LinkedListNode curr = node;
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

	LinkedListNode getMiddle(LinkedListNode head)
	{
		LinkedListNode prev = null;
		LinkedListNode slow = head;
		LinkedListNode fast = head;

		while(fast != null && fast.next != null)
		{
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		return prev;
	}
}