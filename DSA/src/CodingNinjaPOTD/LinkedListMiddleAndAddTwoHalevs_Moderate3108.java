package CodingNinjaPOTD;

import com.example.datastructure.skeleton.LinkedListNode;

// https://www.codingninjas.com/studio/problems/add-first-and-second-half_759343

public class LinkedListMiddleAndAddTwoHalevs_Moderate3108 {
	public static LinkedListNode addFirstAndSecondHalf(LinkedListNode head) {
		// Write your code here.
		if(head == null) return null;
		if(head.next == null) return head;
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		LinkedListNode prev = null;
		int count = 0;
		while(fast != null && fast.next != null)
		{
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
			count++;
		}
		if(count%2 == 0)
		{
			fast = prev.next;
			prev.next = null;
		}
		else
		{
			fast = slow.next;
			slow.next = null;
		}

		head = reverse(head);
		fast = reverse(fast);

		head = sum(head , fast);

		return reverse(head);
	}

	static LinkedListNode reverse(LinkedListNode LinkedListNode)
	{
		LinkedListNode curr = LinkedListNode;
		LinkedListNode temp = null;
		LinkedListNode prev = null;
		while(curr!= null)
		{
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}

	static LinkedListNode sum(LinkedListNode LinkedListNode1, LinkedListNode LinkedListNode2)
	{
		int rem = 0;
		int div = 0;
		LinkedListNode res = new LinkedListNode(-1);
		LinkedListNode temp = res;
		while(LinkedListNode1 != null && LinkedListNode2 != null)
		{
			int sum = div+LinkedListNode1.val+LinkedListNode2.val;
			rem = sum%10;
			div = sum/10;
			temp.next = new LinkedListNode(rem);
			temp = temp.next;
		}
		while(LinkedListNode1 != null)
		{
			int sum = div+LinkedListNode1.val;
			rem = sum%10;
			div = sum/10;
			temp.next = new LinkedListNode(rem);
			temp = temp.next;
		}
		while(LinkedListNode2 != null)
		{
			int sum = div+LinkedListNode2.val;
			rem = sum%10;
			div = sum/10;
			temp.next = new LinkedListNode(rem);
			temp = temp.next;
		}
		if(rem != 0) temp.next = new LinkedListNode(rem);

		return res.next;
	}
}