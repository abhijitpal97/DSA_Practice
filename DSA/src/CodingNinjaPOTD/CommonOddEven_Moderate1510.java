package CodingNinjaPOTD;

import java.util.*;

import com.example.datastructure.skeleton.LinkedListNode;

// https://www.codingninjas.com/studio/problems/intersect-odd-even_920458

public class CommonOddEven_Moderate1510 {

	public static LinkedListNode commonOddEven(LinkedListNode head1, LinkedListNode head2) {

		// Write your code here
		List<Integer> oddlist = new ArrayList<>();
		List<Integer> evenlist = new ArrayList<>();

		while(head1 != null && head2 != null)
		{
			if(head1.val == head2.val)
			{
				if(head1.val%2==0) evenlist.add(head1.val);
				else oddlist.add(head1.val);
				head1 = head1.next;
				head2 = head2.next;
			} 
			else if(head1.val>head2.val) head2 = head2.next;
			else if(head1.val<head2.val) head1 = head1.next;
		}

		LinkedListNode curr = new LinkedListNode(-1);
		LinkedListNode temp = curr;

		for(int i : oddlist)
		{
			temp.next = new LinkedListNode(i);
			temp = temp.next;
		}

		for(int i : evenlist)
		{
			temp.next = new LinkedListNode(i);
			temp = temp.next;
		}

		return curr.next;

	}
}