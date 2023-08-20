package com.example.microsoftpractice;

import com.example.datastructure.skeleton.LinkedListNode;

public class MergeAllNodesBetweenZero {
	public LinkedListNode mergeNodes(LinkedListNode head) {

		LinkedListNode result = new LinkedListNode(0);
		LinkedListNode finalResult = result;
		int temp = 0;
		while(head != null)
		{
			while(head.val != 0 && head != null)
			{
				temp = temp+head.val;

				head = head.next;
			}
			if(temp != 0) { result.next = new LinkedListNode(temp); result = result.next; }
			temp =0;
			if(head != null) head =head.next;
		}

		return finalResult.next;
	}
}