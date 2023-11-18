package StriverSheet175AndLoveBabbar450;

import com.example.datastructure.skeleton.LinkedListNode;

// https://www.codingninjas.com/studio/problems/middle-of-linked-list_973250

public class FindMiddleNode
{
	public static LinkedListNode findMiddle(LinkedListNode head)
	{
		// Write your code here.
		if(head == null) return null;
		if(head.next == null) return head;
		LinkedListNode slow = head;
		LinkedListNode fast = head;

		while(fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}