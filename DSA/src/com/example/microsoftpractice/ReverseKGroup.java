package com.example.microsoftpractice;

import com.example.datastructure.skeleton.LinkedListNode;

// https://leetcode.com/problems/reverse-nodes-in-k-group/description/

public class ReverseKGroup {
	public LinkedListNode reverseKGroup(LinkedListNode head, int k) {
		LinkedListNode temp = head;
		int count = 0;
		while(temp!=null)
		{
			temp = temp.next;
			count++;
		}

		return reverseGroup(head , k , count);
	}

	LinkedListNode reverseGroup(LinkedListNode node, int k , int count)
	{
		if(node == null) return null;
		if(count<k) return node;
		int counter = 0;
		LinkedListNode prev = null;
		LinkedListNode curr = node;
		LinkedListNode temp = null;

		while(curr!=null && counter<k)
		{
			temp = curr.next;
			curr.next=prev;
			prev = curr;
			curr = temp;
			counter++;
		}

		count -=k;

		node.next = reverseGroup(curr , k , count);

		return prev;

	}
}