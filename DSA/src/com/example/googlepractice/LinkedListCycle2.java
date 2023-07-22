package com.example.googlepractice;

import com.example.datastructure.skeleton.LinkedListNode;

public class LinkedListCycle2 {
    public LinkedListNode detectCycle(LinkedListNode head) {
        if(head == null) return null;
        if(head.next == null) return null;
        
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) break;
        }
        if(slow != fast) return null;

        while(head != slow)
        {
            slow = slow.next;
            head = head.next;
        }

        return slow;
    }
}