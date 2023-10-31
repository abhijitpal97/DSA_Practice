package com.example.oracle;

import com.example.datastructure.skeleton.LinkedListNode;

// https://leetcode.com/discuss/interview-question/1507860/oracle-interview-question

public class LinkedListReverseAndDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode node = new LinkedListNode(1);
		node.next= new LinkedListNode(2);
		node.next.next= new LinkedListNode(3);
		node.next.next.next= new LinkedListNode(4);
		node.next.next.next.next= new LinkedListNode(5);
		node.next.next.next.next.next= new LinkedListNode(6);

		LinkedListNode result = function(node);

		StringBuilder sb = new StringBuilder();
		while(result != null)
		{
			sb.append(result.val).append("->");
			result = result.next;
		}
		sb.setLength(sb.length()-2);
		System.out.println(sb.toString());

	}

	static LinkedListNode function(LinkedListNode node)
	{
		LinkedListNode slow = node;
		LinkedListNode fast = node;
		LinkedListNode prev = null;
		while(fast != null && fast.next != null)
		{
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		LinkedListNode second = prev.next;
		prev.next = null;
		LinkedListNode first = reverse(node);
		LinkedListNode firstT = first;
		LinkedListNode secondT = second;
		
		LinkedListNode result = new LinkedListNode(-1);
		LinkedListNode res = result;
		int temp = 0;
		boolean flag = true;
		while(firstT != null && secondT != null)
		{
			if(!flag)
			{
				temp = firstT.val;
				firstT.val = secondT.val;
				secondT.val = temp;
			}
			flag = !flag;
			firstT = firstT.next;
			secondT= secondT.next;
		}
		
		second = reverse(second);
		while(second != null)
		{
			res.next = new LinkedListNode(second.val);
			res = res.next;
			second = second.next;
			
		}
		//first = reverse(first);
		while(first != null)
		{
			res.next = new LinkedListNode(first.val);
			res = res.next;
			first = first.next;
			
		}
		return result.next;
	}

	private static LinkedListNode reverse(LinkedListNode node) {
		// TODO Auto-generated method stub
		LinkedListNode curr = node;
		LinkedListNode prev = null;
		LinkedListNode temp = null;
		
		while( curr != null)
		{
			temp = curr.next;
			curr.next = prev;
			prev= curr;
			curr = temp;
		}
		
		return prev;
	}

}
