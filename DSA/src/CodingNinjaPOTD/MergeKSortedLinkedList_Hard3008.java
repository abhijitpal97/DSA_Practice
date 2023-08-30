package CodingNinjaPOTD;
import java.util.*;

import com.example.datastructure.skeleton.LinkedListNode;

public class MergeKSortedLinkedList_Hard3008 {
	public static LinkedListNode mergeKLists(LinkedListNode[] listArray) {
		// Write your code here.
		Queue<Integer> queue = new PriorityQueue<>();

		for(int i=0;i<listArray.length;i++)
		{
			LinkedListNode curr = listArray[i];
			while(curr != null)
			{
				queue.offer(curr.val);
				curr = curr.next;
			}
		}

		LinkedListNode result = new LinkedListNode(-1);
		LinkedListNode temp = result;

		while(! queue.isEmpty())
		{
			temp.next = new LinkedListNode(queue.poll());
			temp = temp.next;
		}
		return result.next;
	}
}