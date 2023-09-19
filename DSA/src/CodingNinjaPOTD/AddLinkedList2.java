package CodingNinjaPOTD;

import com.example.datastructure.skeleton.LinkedListNode;

public class AddLinkedList2 {
	public static LinkedListNode addTwoLists(LinkedListNode first, LinkedListNode second) {
		// Write your code here.
		first = reverse(first);
		second = reverse(second);

		int rem = 0 ;
		int div = 0;
		LinkedListNode curr = new LinkedListNode(-1);
		LinkedListNode temp = curr;

		while(first != null && second != null)
		{
			int sum = first.val+second.val+div;
			rem = sum%10;
			div = sum/10;

			temp.next = new LinkedListNode(rem);
			temp = temp.next;
			first = first.next;
			second = second.next;
		}
		while(first != null)
		{
			int sum = first.val+div;
			rem = sum%10;
			div = sum/10;

			temp.next = new LinkedListNode(rem);
			temp = temp.next;
			first = first.next;
		}
		while(second != null)
		{
			int sum = second.val+div;
			rem = sum%10;
			div = sum/10;

			temp.next = new LinkedListNode(rem);
			temp = temp.next;
			second = second.next;
		}

		if(div != 0) 
		{
			temp.next = new LinkedListNode(div);
			temp = temp.next;
		}

		return reverse(curr.next);

	}

	static LinkedListNode reverse (LinkedListNode root)
	{
		LinkedListNode curr = root;
		LinkedListNode prev = null;
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