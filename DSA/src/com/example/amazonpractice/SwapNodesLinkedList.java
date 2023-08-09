package com.example.amazonpractice;

import com.example.datastructure.skeleton.LinkedListNode;

public class SwapNodesLinkedList {

	public static void main(String[] args)
	{
		LinkedListNode node = new LinkedListNode(7);
		node.next = new LinkedListNode(9);
		node.next.next = new LinkedListNode(6);
		node.next.next.next = new LinkedListNode(6);
		node.next.next.next.next = new LinkedListNode(7);
		node.next.next.next.next.next = new LinkedListNode(8);
		node.next.next.next.next.next.next = new LinkedListNode(3);

		swapNodes(node, 3);
	}

	public static LinkedListNode swapNodes(LinkedListNode head, int k) {


		if(head == null) return null;
		if(head.next == null) return head;

		LinkedListNode slow = head;
		LinkedListNode fast = head;

		int k1 = 1;
		while(k1<k)
		{
			fast=fast.next;
			k1++;
		}
		LinkedListNode curr = fast;
		while(curr.next != null)
		{
			slow = slow.next;
			curr=curr.next;
		}

		int temp = slow.val;
		slow.val = fast.val;
		fast.val = temp;

		return head;
	}


}