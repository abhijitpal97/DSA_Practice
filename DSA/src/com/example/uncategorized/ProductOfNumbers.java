package com.example.uncategorized;

import com.example.datastructure.skeleton.LinkedListNode;

public class ProductOfNumbers {
	static LinkedListNode head = new LinkedListNode(-1);

	public static void main(String[] args)
	{
		ProductOfNumbers obj = new ProductOfNumbers();
		obj.add(3);
		obj.add(0);
		obj.add(2);
		obj.add(5);
		obj.add(4);
		int param_2 = obj.getProduct(2);
		System.out.println(param_2);
		int param_3 = obj.getProduct(3);
		System.out.println(param_3);
		int param_4 = obj.getProduct(4);
		System.out.println(param_4);
		obj.add(8);
		int param_5 = obj.getProduct(2);
		System.out.println(param_5);

	}
	public static void add(int num) {
		LinkedListNode temp = head.next;
		LinkedListNode newLinkedListNode = new LinkedListNode(num);
		head.next = newLinkedListNode;
		newLinkedListNode.next = temp;
	}

	public static int getProduct(int k) {
		LinkedListNode temp = head.next;
		int prod = 1;

		while(temp != null && k>0)
		{
			prod *= temp.val;
			temp = temp.next;
			k--;
		}
		if(k != 0) return 0;
		return prod;
	}
}