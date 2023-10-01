package com.example.microsoftpractice;

import com.example.datastructure.skeleton.LinkedListNode;

// https://leetcode.com/problems/swap-nodes-in-pairs/description/

public class SwapPairNode {
	public LinkedListNode swapPairs(LinkedListNode head) {
		return reverse(head , 2);
	}

	LinkedListNode reverse(LinkedListNode node , int k)
	{
		if(node == null) return null;
		int counter = 0;
		LinkedListNode curr = node;
		LinkedListNode prev = null;
		LinkedListNode temp = null;
		while(curr!=null && counter<k)
		{
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
			counter++;
		}

		node.next = reverse(curr , k);
		return prev;
	}
}