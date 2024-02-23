package com.example.leetCode75;

import java.util.*;
import com.example.datastructure.skeleton.LinkedListNode;

// https://leetcode.com/problems/odd-even-linked-list/

public class OddEvenList {
	// With O(n) space

	public LinkedListNode oddEvenList(LinkedListNode head) {
		if(head == null) return null;
		if(head.next == null) return head;

		List<Integer> odd = new LinkedList<Integer>();
		List<Integer> even = new LinkedList<Integer>();

		int index = 0;
		while(head != null)
		{
			if(index%2 == 0) odd.add(head.val);
			else even.add(head.val);

			head = head.next;
			index++;
		}

		System.out.println(odd);
		System.out.println(even);

		head = new LinkedListNode(-1);
		LinkedListNode temp = head;

		for(int i=0;i<odd.size();i++)
		{
			temp.next = new LinkedListNode(odd.get(i));
			temp = temp.next;
		}

		for(int i=0;i<even.size();i++)
		{
			temp.next = new LinkedListNode(even.get(i));
			temp = temp.next;
		}

		return head.next;

	}

	// Without Extra Space
	public LinkedListNode oddEvenListWES(LinkedListNode head) {


		// Write your code here
		if(head == null) return null;
		if(head.next == null) return head;

		LinkedListNode node = new LinkedListNode(-1);
		LinkedListNode temp = node;

		LinkedListNode odd = head;
		LinkedListNode even = head.next;

		while(odd.next != null && odd.next.next != null)
		{
			temp.next = new LinkedListNode(odd.val);
			odd = odd.next.next;
			temp = temp.next;
		}
		temp.next = new LinkedListNode(odd.val);
		temp=temp.next;

		while(even.next != null && even.next.next != null)
		{
			temp.next = new LinkedListNode(even.val);
			even = even.next.next;
			temp = temp.next;
		}
		temp.next = new LinkedListNode(even.val);
		temp=temp.next;

		return node.next;

	}
}