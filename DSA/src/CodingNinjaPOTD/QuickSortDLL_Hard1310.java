package CodingNinjaPOTD;

import java.util.*;

import com.example.datastructure.skeleton.DoubleLinkedListNode;

// https://www.codingninjas.com/studio/problems/quicksort-on-doubly-linked-list_1071013

public class QuickSortDLL_Hard1310 {
	public static DoubleLinkedListNode quickSort(DoubleLinkedListNode head) {
		// Write your code here
		List<Integer> list = new ArrayList<>();
		traversal(head , list);
		quickSort(list,0,list.size()-1);

		head = new DoubleLinkedListNode(list.get(0));
		DoubleLinkedListNode result = head;
		for(int i=1;i<list.size();i++)
		{
			DoubleLinkedListNode temp = new DoubleLinkedListNode(list.get(i));
			result.next = temp;
			temp.prev = result;
			result = result.next;
		}

		return head;
	}

	static void traversal(DoubleLinkedListNode node , List<Integer> list)
	{
		while(node != null)
		{
			list.add(node.data);
			node = node.next;
		}
	}

	static void quickSort(List<Integer> list , int start , int end)
	{
		if(start<end)
		{
			int mid = getPivot(list,start,end);
			quickSort(list , start , mid-1);
			quickSort(list , mid+1 , end);
		}
	}

	static int getPivot(List<Integer> list , int start , int end)
	{
		int pivot = list.get(start);
		int i = start;
		int j = end;

		while(i<j)
		{
			while(list.get(i) <= pivot && i<end) i++;
			while(list.get(j) > pivot) j--;

			if(i<j) swap(list , i , j);
		}

		swap(list , j , start);

		return j;
	}

	static void swap(List<Integer> list , int i , int j)
	{
		int temp = list.get(i);
		list.set(i , list.get(j));
		list.set(j , temp);
	}
}

