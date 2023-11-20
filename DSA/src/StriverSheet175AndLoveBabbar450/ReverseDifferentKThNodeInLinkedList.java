package StriverSheet175AndLoveBabbar450;

import com.example.datastructure.skeleton.LinkedListNode;
// https://www.codingninjas.com/studio/problems/reverse-blocks_763406

public class ReverseDifferentKThNodeInLinkedList {
	public static LinkedListNode getListAfterReverseOperation(LinkedListNode head, int n, int b[]) {
		// Write your code here.
		// 1 2 3 4 5 6 7 8 9 10 11 -1
		if(head == null) return null;
		return reverse(head , 0 , b , n);
	}

	static LinkedListNode reverse(LinkedListNode head , int index , int b[] , int n)
	{
		if(index>=b.length) return head;
		if(head == null) return head;
		if(b[index] == 0) return reverse(head , index+1 , b , n);

		LinkedListNode curr = head;
		LinkedListNode prev = null;
		LinkedListNode temp = null;
		int counter = 0;
		while(curr != null && counter<b[index])
		{
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
			counter++;
		}
		// 2 -> {2 1 3 4 5 6 7 8 9 10 11 -1}
		// 3 -> {2 1 5 4 3 6 7 8 9 10 11 -1}
		// 4 -> {2 1 5 4 3 9 8 7 6 10 11 -1}
		// 6 -> {2 1 5 4 3 9 8 7 6 11 10 -1}
		head.next = reverse(curr , index+1 , b,n);
		return prev;
	}
}