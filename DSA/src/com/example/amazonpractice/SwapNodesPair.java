package com.example.amazonpractice;

import com.example.datastructure.skeleton.LinkedListNode;

public class SwapNodesPair {
	public LinkedListNode swapPairs(LinkedListNode head) {
		int count = 0;
		LinkedListNode temp = head;

		while(temp != null)
		{
			count++;
			temp = temp.next;
		}

		if(count < 2) return head;

		return reversePair(head , count);
	}

	static LinkedListNode reversePair(LinkedListNode head , int count)
	{
		if(head == null) return null;
		if(count < 2) return head;

		LinkedListNode curr = head;
		LinkedListNode temp = null;
		LinkedListNode prev = null;
		int index = 0;
		while(index<2)
		{
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
			index++;
		}
		count -= 2;

		head.next = reversePair(curr , count);

		return prev;
	}
}