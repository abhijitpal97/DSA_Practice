package CodingNinjaPOTD;

import com.example.datastructure.skeleton.DoubleLinkedListNode;

// https://www.codingninjas.com/studio/problems/reverse-dll-nodes-in-groups_920399?leftPanelTab=0

public class ReverseDLLInKGroups_Moderate0610 {
	public static DoubleLinkedListNode reverseDLLInGroups(DoubleLinkedListNode head, int k) {
		// Write your code here.
		if(head == null) return null;

		DoubleLinkedListNode prev = null;
		DoubleLinkedListNode curr = head;
		DoubleLinkedListNode temp = null;
		int counter = 0;

		while(curr != null && counter<k)
		{
			temp = curr.next;
			curr.next = prev;
			if(prev != null) prev.prev = curr;
			prev = curr;
			curr = temp;
			counter++;
		}

		head.next = reverseDLLInGroups(curr , k);


		return prev;

	}


}
