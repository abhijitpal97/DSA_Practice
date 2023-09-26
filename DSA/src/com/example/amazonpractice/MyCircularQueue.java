package com.example.amazonpractice;

import com.example.datastructure.skeleton.DoubleLinkedListNode;

// https://leetcode.com/problems/design-circular-queue/description/

public class MyCircularQueue {
	DoubleLinkedListNode head = new DoubleLinkedListNode();
	DoubleLinkedListNode tail = new DoubleLinkedListNode();
	int k;
	int size = 0;
	public MyCircularQueue(int k) {
		head.next = tail;
		tail.prev = head;
		this.k = k;
	}

	public boolean enQueue(int value) {
		if(size == k) return false;
		DoubleLinkedListNode temp = head.next;
		DoubleLinkedListNode curr = new DoubleLinkedListNode(value);
		head.next = curr;
		curr.next = temp;
		temp.prev = curr;
		curr.prev = head;
		size++;
		return true;
	}

	public boolean deQueue() {
		if(size == 0) return false;
		DoubleLinkedListNode temp = tail.prev;
		DoubleLinkedListNode currPrev = temp.prev;
		currPrev.next = tail;
		tail.prev = currPrev;
		size--;
		return true;

	}

	public int Front() {
		if(size == 0) return -1;
		return tail.prev.data;
	}

	public int Rear() {
		if(size==0) return -1;
		return head.next.data;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size==k;
	}
}