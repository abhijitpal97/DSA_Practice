package com.example.datastructure.skeleton;

public class DoubleLinkedListNode
{
	public int data;
	public long value;
	public DoubleLinkedListNode next;
	public DoubleLinkedListNode prev;
	public int key;
	public String val;
	public DoubleLinkedListNode(int data , int key)
	{
		this.data = data;
		this.key = key;
	}
	public DoubleLinkedListNode(int data)
	{
		this.data = data;
	}
	public DoubleLinkedListNode(long value)
	{
		this.value = value;
	}

	public DoubleLinkedListNode(String val)
	{
		this.val=val;
	}

	public DoubleLinkedListNode(){}
}

