package com.example.oracle;

import com.example.datastructure.skeleton.DoubleLinkedListNode;

// https://leetcode.com/problems/design-browser-history/

class BrowserHistory {
	DoubleLinkedListNode head;

	public BrowserHistory(String homepage) {
		head = new DoubleLinkedListNode(homepage);
	}

	public void visit(String url) {
		DoubleLinkedListNode curr = new DoubleLinkedListNode(url);
		head.next = curr;
		curr.prev = head;
		curr.next = null;
		head = head.next;
	}

	public String back(int steps) {
		DoubleLinkedListNode curr = head;
		while(curr.prev != null && steps>0)
		{
			curr = curr.prev;
			steps--;
		}

		head = curr;
		return head.val;
	}

	public String forward(int steps) {
		DoubleLinkedListNode curr = head;
		while(curr.next != null && steps>0)
		{
			curr = curr.next;
			steps--;
		} 
		head = curr;
		return head.val;
	}
}