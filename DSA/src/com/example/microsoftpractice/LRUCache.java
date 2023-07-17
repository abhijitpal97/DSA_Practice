package com.example.microsoftpractice;

import java.util.*;

import com.example.datastructure.skeleton.DoubleLinkedListNode;

public class LRUCache {
	
    DoubleLinkedListNode head = new DoubleLinkedListNode();
    DoubleLinkedListNode tail = new DoubleLinkedListNode();
    int capacity;
    Map<Integer,DoubleLinkedListNode> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            DoubleLinkedListNode DoubleLinkedListNode = map.get(key);
            remove(DoubleLinkedListNode);
            add(DoubleLinkedListNode);
            return DoubleLinkedListNode.data;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            DoubleLinkedListNode DoubleLinkedListNode = map.get(key);
            remove(DoubleLinkedListNode);
            DoubleLinkedListNode.data = value;
            add(DoubleLinkedListNode);
        }
        else
        {
            DoubleLinkedListNode DoubleLinkedListNode = new DoubleLinkedListNode(value , key);
            if(map.size()==capacity)
            {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            add(DoubleLinkedListNode);
            map.put(key , DoubleLinkedListNode);
        }
    }

    public void add(DoubleLinkedListNode DoubleLinkedListNode)
    {
        DoubleLinkedListNode temp = head.next;
        head.next = DoubleLinkedListNode;
        DoubleLinkedListNode.next = temp;
        temp.prev = DoubleLinkedListNode;
        DoubleLinkedListNode.prev = head;
    }

    public void remove(DoubleLinkedListNode DoubleLinkedListNode)
    {
        DoubleLinkedListNode currNext = DoubleLinkedListNode.next;
        DoubleLinkedListNode currPrev = DoubleLinkedListNode.prev;
        currPrev.next = currNext;
        currNext.prev = currPrev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */