package StriverSheet175AndLoveBabbar450;

import com.example.datastructure.skeleton.LinkedListNode;

// https://www.codingninjas.com/studio/problems/cycle-detection-in-a-singly-linked-list_628974

public class LinkedListCycle1 {

	public static boolean detectCycle(LinkedListNode head) {
		//Your code goes here
		if(head == null) return false;
		if(head.next == null) return false;
		LinkedListNode slow = head;
		LinkedListNode fast = head;

		while(fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;

			if(slow == fast) return true;
		}

		return false;
	}
}