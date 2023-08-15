package LeetCodePOTD;

import com.example.datastructure.skeleton.LinkedListNode;

public class PartitionLinkedList {
    public LinkedListNode partition(LinkedListNode head, int x) {
        if(head == null) return null;
        if(head.next == null) return head;

        LinkedListNode l1 = new LinkedListNode(-1);
        LinkedListNode l2 = new LinkedListNode(-1);
        LinkedListNode temp1 = l1;
        LinkedListNode temp2 = l2;

        while(head != null)
        {
            if(head.val < x)
            {
                temp1.next = new LinkedListNode(head.val);
                temp1=temp1.next;
            }
            else
            {
                temp2.next = new LinkedListNode(head.val);
                temp2 = temp2.next;
            }
            head=head.next;
        }
        temp1.next = l2.next;
        return l1.next;
    }
}