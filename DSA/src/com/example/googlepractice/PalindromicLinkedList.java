package com.example.googlepractice;

import com.example.datastructure.skeleton.LinkedListNode;

// https://leetcode.com/problems/palindrome-linked-list/

public class PalindromicLinkedList {
	public boolean isPalindrome(LinkedListNode head) {
		if(head == null) return true;
		if(head.next == null) return true;
		LinkedListNode middle = getMiddle(head);
		LinkedListNode reversed = getReverse(middle.next);
		middle.next = null;

		while(head != null)
		{
			if(head.val != reversed.val) return false;
			head = head.next;
			reversed = reversed.next;
		}

		return true;
	}

	LinkedListNode getMiddle(LinkedListNode node)
	{
		LinkedListNode slow = node;
		LinkedListNode fast = node;
		LinkedListNode prev = null;
		while(fast != null && fast.next != null)
		{
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		return prev;
	}

	LinkedListNode getReverse(LinkedListNode node)
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
}