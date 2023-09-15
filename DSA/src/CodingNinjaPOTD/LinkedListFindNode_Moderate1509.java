package CodingNinjaPOTD;
import java.util.* ;

import com.example.datastructure.skeleton.LinkedListNode;

import java.io.*; 


public class LinkedListFindNode_Moderate1509 {
	public static LinkedListNode  findNode(LinkedListNode head, int n) {
		// Write your code here.
		if(head == null) return null;
		if(head.next == null) return null;
		LinkedListNode slow = head;
		LinkedListNode fast = head;

		while(fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;

			if(slow == fast) break;
		}

		LinkedListNode curr = head;
		int count = 1;
		while(curr != slow)
		{
			curr = curr.next;
			slow = slow.next;
			count++;
		}

		if(count != 1)
		{
			count -= n;
			if(count<0) return null;
			while(count != 1)
			{
				head = head.next;
				count--;
			}
			return head;
		}
		return null;
	}
}