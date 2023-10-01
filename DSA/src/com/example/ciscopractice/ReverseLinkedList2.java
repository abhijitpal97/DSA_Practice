package com.example.ciscopractice;

import com.example.datastructure.skeleton.LinkedListNode;

// https://leetcode.com/problems/reverse-linked-list-ii/description/

public class ReverseLinkedList2 {

	public LinkedListNode reverseBetween(LinkedListNode head, int left, int right) {
		LinkedListNode node = new LinkedListNode(0);
		node.next = head;
		LinkedListNode result = node;
		int pos = 1;
		while(pos < left)
		{
			node = node.next;
			pos++;
		}

		node.next = reverseNode(node.next , right-left);

		return result.next;
	}

	public LinkedListNode reverseNode (LinkedListNode node , int counter)
	{
		if(node == null || node.next == null) return node;

		LinkedListNode prev = null;
		LinkedListNode curr = node;
		LinkedListNode temp = null;

		while(counter >=0 && curr!=null)
		{
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
			counter--;
		}
		node.next = curr;


		return prev;
	}
}