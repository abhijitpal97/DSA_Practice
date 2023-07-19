package com.example.ciscopractice;

import com.example.datastructure.skeleton.LinkedListNode;

public class ReOrderList {
    public void reorderList(LinkedListNode head) {
        if(head == null) return ;
        if(head.next == null) return ;
        if(head.next.next == null) return ;

        LinkedListNode middle = getMiddle(head);
        //System.out.println(middle.val);
        LinkedListNode part2 = middle.next;
        //System.out.println(" - "+part2.val);
        middle.next = null;
        part2 = reverse(part2);

        LinkedListNode result = head;
        LinkedListNode temp = null;
        
        while(part2 != null)
        {
            temp = result.next;
            result.next =part2;
            part2 = part2.next;
            result.next.next = temp;
            result = result.next.next;
        }
    }

    LinkedListNode getMiddle(LinkedListNode node)
    {
        LinkedListNode slow = node;
        LinkedListNode fast = node;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    LinkedListNode reverse(LinkedListNode node)
    {
        LinkedListNode curr = node;
        LinkedListNode prev = null;
        LinkedListNode temp = null;

        while(curr != null)
        {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}