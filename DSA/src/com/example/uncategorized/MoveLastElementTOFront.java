package com.example.uncategorized;

import com.example.datastructure.skeleton.LinkedListNode;

public class MoveLastElementTOFront {

	public static LinkedListNode moveToFront(LinkedListNode head) {
		// Write your code here
		if(head == null) return null;
		if(head.next == null) return head;

		LinkedListNode curr = head;
		LinkedListNode temp = head.next;

		while(temp.next != null)
		{
			temp = temp.next;
			curr = curr.next;
		}
		temp.next = head;
		curr.next = null;
		return temp;
	}

}