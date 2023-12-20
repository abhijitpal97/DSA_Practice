package com.example.microsoftpractice;

import com.example.datastructure.skeleton.LinkedListNode;

// https://practice.geeksforgeeks.org/problems/sorted-insert-for-circular-linked-list/1

public class InsertIntoCyclicList
{
	public static LinkedListNode sortedInsert(LinkedListNode head,int data)
	{
		//add code here.
		LinkedListNode tail = head;
		while(tail.next != head) tail = tail.next;

		LinkedListNode newNode = new LinkedListNode(data);

		if(head == null || data<head.val)
		{
			newNode.next = head;
			tail.next = newNode;
			return newNode;
		}

		if(data>tail.val)
		{
			LinkedListNode curr = tail.next;
			tail.next = newNode;
			newNode.next = curr;
			return head;
		}

		LinkedListNode temp = head;

		while(temp.next.val<data) temp = temp.next;

		LinkedListNode curr = temp.next;
		newNode.next = curr;
		temp.next = newNode;

		return head;
	}
}