package com.example.oracle;
import java.util.* ;

import com.example.datastructure.skeleton.LinkedListNode;

import java.io.*; 

// https://www.codingninjas.com/studio/problems/moderate_6114314

public class LastApperenceNode {
	public static LinkedListNode lastAppearance(LinkedListNode head) {
		// Write your code here
		Map<Integer,Integer> map = new HashMap<>();
		int index=0;

		while(head != null)
		{
			int val = head.val;
			map.put(val,index);
			head = head.next;
			index++;
		}

		List<Map.Entry<Integer,Integer>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>()
		{
			public int compare(Map.Entry<Integer,Integer> o1 , Map.Entry<Integer,Integer> o2)
			{
				return o1.getValue().compareTo(o2.getValue());
			}
		});

		head = new LinkedListNode(-1);
		LinkedListNode temp = head;

		for(Map.Entry<Integer,Integer> m1 : list)
		{
			temp.next = new LinkedListNode(m1.getKey());
			temp = temp.next;
		}

		return head.next;




	}
}