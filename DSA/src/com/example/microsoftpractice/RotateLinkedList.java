package com.example.microsoftpractice;

import com.example.datastructure.skeleton.LinkedListNode;

// https://leetcode.com/problems/rotate-list/

public class RotateLinkedList {
	public LinkedListNode rotateRight(LinkedListNode head, int k) {
		if(head == null) return head;
		if(head.next == null) return head;

		LinkedListNode temp = head;

		int count = 1;
		while(temp.next != null)
		{
			temp = temp.next;
			count++;
		}
		if(k>count) k = k%count;
		temp.next = head;
		count = count - k;

		while(count > 0)
		{
			temp = temp.next;
			head=head.next;
			count--;
		}  
		temp.next = null;

		return head;
	}

	// Using 2 pointer - Linked List
	public LinkedListNode rotateRight2P(LinkedListNode head, int k) {
		if(head == null) return null;
		if(head.next == null) return head;
		LinkedListNode temp = head;
		int count = 0;
		while(temp != null)
		{
			count++;
			temp = temp.next;
		}
		if(k>=count)  k = k%count;
		//System.out.println(k + " - "+count+ " - "+k%count);
		if(k == 0) return head;
		temp = head;
		while(k != 0)
		{
			temp = temp.next;
			k--;
		}
		LinkedListNode curr = head;

		while(temp.next != null)
		{
			temp = temp.next;
			curr = curr.next;
		}
		temp.next = head;
		LinkedListNode res = curr.next;
		curr.next = null;
		return res;
	}
}