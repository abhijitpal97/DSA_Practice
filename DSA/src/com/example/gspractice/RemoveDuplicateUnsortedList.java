package com.example.gspractice;

import java.util.*;

import com.example.datastructure.skeleton.LinkedListNode;

// https://practice.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/1

public class RemoveDuplicateUnsortedList
{
	//Function to remove duplicates from unsorted linked list.
	public LinkedListNode removeDuplicates(LinkedListNode head) 
	{
		// Your code here
		if(head == null) return null;
		if(head.next == null) return head;
		LinkedListNode result = new LinkedListNode (-1);
		Set<Integer> set = new HashSet<>();
		LinkedListNode temp = result;

		while(head != null)
		{
			if(set.add(head.val))
			{
				temp.next = new LinkedListNode(head.val);
				temp = temp.next;
				head = head.next;
			}
			else
			{
				head = head.next;
			}
		}

		return result.next;
	}
}
