package com.example.microsoftpractice;

import com.example.datastructure.skeleton.LinkedListNode;

public class RotateLinkedList {
    public LinkedListNode rotateRight(LinkedListNode head, int k) {
        if(head == null) return head;
        if(head.next == null) return head;

        LinkedListNode temp = head;
      
        int count = 1;
        while(temp.next != null)
        {
            temp = temp.next;
            count++;
        }
        if(k>count) k = k%count;
        temp.next = head;
        count = count - k;

        while(count > 0)
        {
            temp = temp.next;
            head=head.next;
            count--;
        }  
        temp.next = null;

        return head;
    }
}