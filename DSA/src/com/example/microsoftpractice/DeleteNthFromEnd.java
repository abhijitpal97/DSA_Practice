package com.example.microsoftpractice;

import com.example.datastructure.skeleton.LinkedListNode;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

public class DeleteNthFromEnd {
	public LinkedListNode removeNthFromEnd(LinkedListNode head, int n) {
		LinkedListNode curr = head;
		while(curr != null && n>0)
		{
			curr = curr.next;
			n--;
		}
		if(n != 0) return head;

		LinkedListNode temp = head;
		if(curr == null) return head.next;
		curr = curr.next;

		while(curr != null)
		{
			curr = curr.next;
			temp = temp.next;
		} 
		temp.next = temp.next.next;

		return head;
	}
}