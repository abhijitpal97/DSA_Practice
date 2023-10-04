package com.example.microsoftpractice;

import java.util.*;

import com.example.datastructure.skeleton.LinkedListNode;

// https://leetcode.com/problems/copy-list-with-random-pointer/description/

public class CopyRandomPointerList {
	public LinkedListNode copyRandomList(LinkedListNode head) {
		HashMap<LinkedListNode , LinkedListNode> map = new HashMap<>();
		LinkedListNode temp = head;
		while(temp != null)
		{
			map.put(temp , new LinkedListNode(temp.val));
			temp = temp.next;
		}

		LinkedListNode copy = head;
		while(copy != null)
		{
			map.get(copy).next = map.get(copy.next);
			map.get(copy).random = map.get(copy.random);
			copy = copy.next;
		}

		return map.get(head);
	}
}