package com.example.microsoftpractice;

import com.example.datastructure.skeleton.LinkedListNode;

// https://leetcode.com/problems/intersection-of-two-linked-lists/description/

public class IntersectionListNode {
	public LinkedListNode getIntersectionNode(LinkedListNode headA, LinkedListNode headB) {
		if(headA == null || headB == null) return null;
		int c1 = getCount(headA);
		int c2 = getCount(headB);
		while(c1>c2)
		{
			headA = headA.next;
			c1--;
		}
		while(c2 > c1)
		{
			headB = headB.next;
			c2--;
		}

		while(headA != null)
		{
			if(headA == headB) return headA;
			headA = headA.next;
			headB = headB.next;
		}

		return null;

	}

	int getCount(LinkedListNode node)
	{
		if(node == null) return 0;

		int count =0;
		while(node != null)
		{
			count++;
			node = node.next;
		}
		return count;
	}
}