package CodingNinjaPOTD;

import com.example.datastructure.skeleton.LinkedListNode;

// https://www.codingninjas.com/studio/problems/rearrange-odd-and-even-places_920379?

public class RearrangeOddEvenPlaces_Moderate0210 {

	public static void main(String[] args)
	{
		LinkedListNode node = new LinkedListNode(1);
		node.next = new LinkedListNode(2);
		node.next.next = new LinkedListNode(3);
		node.next.next.next = new LinkedListNode(4);
		node.next.next.next.next = new LinkedListNode(5);
		LinkedListNode res =  oddEvenList(node);

		StringBuilder sb = new StringBuilder();

		while(res != null) 
		{
			sb.append(res.val).append(" ");
			res = res.next;
		}

		System.out.println(sb);
	}

	public static LinkedListNode oddEvenList(LinkedListNode head) {
		if(head == null) return null;
		if(head.next == null) return head;

		LinkedListNode odd = head;
		LinkedListNode even = head.next;
		LinkedListNode res = new LinkedListNode(odd.val);
		LinkedListNode temp = res;

		while(odd.next != null && odd.next.next != null)
		{
			temp.next = new LinkedListNode(odd.next.next.val);
			temp = temp.next;
			odd = odd.next.next;
		}
		temp.next = new LinkedListNode(even.val);
		temp = temp.next;
		while(even.next != null && even.next.next != null)
		{
			temp.next = new LinkedListNode(even.next.next.val) ;
			temp = temp.next;
			even = even.next.next;
		}

		return res;
	}
}