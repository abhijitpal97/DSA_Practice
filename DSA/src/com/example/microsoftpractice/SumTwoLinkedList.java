package com.example.microsoftpractice;

import com.example.datastructure.skeleton.LinkedListNode;

// https://leetcode.com/problems/add-two-numbers/description/

public class SumTwoLinkedList {

	public LinkedListNode addTwoNumbers(LinkedListNode l1, LinkedListNode l2) {
		l1 = reverse(l1);
		l2 = reverse(l2);
		int rem = 0;
		int div = 0;
		LinkedListNode result = new LinkedListNode(-1);
		LinkedListNode temp = result;

		while(l1!=null && l2 != null)
		{
			int sum = div+l1.val+l2.val;
			rem = sum%10;
			div=sum/10;
			temp.next=new LinkedListNode(rem);
			l1 = l1.next;
			l2 = l2.next;
			temp = temp.next;
		}
		while(l1 != null)
		{
			int sum = div+l1.val;
			rem = sum%10;
			div=sum/10;
			temp.next = new LinkedListNode(rem);
			l1 = l1.next;
			temp = temp.next;
		}
		while(l2 != null)
		{
			int sum = div+l2.val;
			rem = sum%10;
			div=sum/10;
			temp.next = new LinkedListNode(rem);
			l2 = l2.next;
			temp = temp.next;
		}
		if(div != 0) temp.next = new LinkedListNode(div);

		return reverse(result.next);   
	}

	LinkedListNode reverse(LinkedListNode node)
	{
		LinkedListNode prev =  null;
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