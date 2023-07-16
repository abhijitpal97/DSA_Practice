package com.example.amazonpractice;

import com.example.datastructure.skeleton.LinkedListNode;

public class MergeInbetweenLL {
	public LinkedListNode mergeInBetween(LinkedListNode list1, int a, int b, 
			LinkedListNode list2) {
		LinkedListNode result = list1;
		int count=0;
		while(count != a-1) 
		{
			count++;
			list1 = list1.next;
		}
		LinkedListNode temp1 = list1.next;
		list1.next = list2;
		list1 = list1.next;
		while(list2.next != null)
		{
			list2=list2.next;
			list1 = list1.next;
		}
		LinkedListNode temp = list1;
		list1.next = temp1;
		list1 = list1.next;
		while(count != b-1) 
		{
			count++;
			list1 = list1.next;
		}
		temp.next = list1.next;

		return result;
	}
}