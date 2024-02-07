package com.example.amazonpractice;

import java.util.*;

import com.example.datastructure.skeleton.LinkedListNode;

// https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/description/

public class RemoveConsecutiveZeros {

	public static void main(String[] args)
	{
		LinkedListNode node = new LinkedListNode(1);
		node.next = new LinkedListNode(2);
		node.next.next = new LinkedListNode(-3);
		node.next.next.next = new LinkedListNode(3);
		node.next.next.next.next = new LinkedListNode(1);

		LinkedListNode res = removeZeroSumSublists(node);

		while(res != null)
		{
			System.out.println(res.val);
			res = res.next;
		}
	}
	public static LinkedListNode removeZeroSumSublists(LinkedListNode head) {
		List<Integer> list = new ArrayList<>();

		while(head != null)
		{
			list.add(head.val);
			head = head.next;
		}

		List<Integer> result = new ArrayList<>();

		while(list.size() != result.size())
		{
			result = new ArrayList<>(list);
			list = function(list);
		}

		if(list.size() == 0) return null;

		LinkedListNode res = new LinkedListNode(list.get(0));
		LinkedListNode temp = res;

		for(int i=1;i<list.size();i++)
		{
			temp.next = new LinkedListNode(list.get(i));
			temp = temp.next;
		}
		return res;
	}

	static List<Integer> function(List<Integer> list)
	{
		Map<Integer,Integer> map = new HashMap<>();
		map.put(0 , -1);
		int curr = 0;
		for(int i=0;i<list.size() ; i++)
		{
			curr += list.get(i);

			if(map.containsKey(curr))
			{
				int endIndex = map.get(curr)+1;
				int startIndex = i+1;
				List<Integer> res = new ArrayList<>();
				for(int j=0;j<endIndex;j++) res.add(list.get(j));
				for(int j=startIndex;j<list.size();j++) res.add(list.get(j));
				return res;
			}
			map.put(curr , i);
		}
		return list;
	}
}