package com.example.googlepractice;

import java.util.*;

import com.example.datastructure.skeleton.LinkedListNode;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/

public class RemoveDuplicateFromLinkedList2 {
    public LinkedListNode deleteDuplicates(LinkedListNode head) {
        Stack<Integer> stack = new Stack<>();

        while(head != null)
        {
            if(stack.isEmpty())
            {
                stack.push(head.val);
            }
            else
            {
                if(stack.peek() == head.val) stack.push(head.val);
                else
                {
                    int count = 0;
                    int temp = stack.pop();
                    while(!stack.isEmpty() && temp == stack.peek())
                    {
                        stack.pop();
                        count++;
                    }
                    if(count == 0) stack.push(temp);

                stack.push(head.val);

                }

            }
            head = head.next;
        }

        if(stack.isEmpty()) return null;
        int count = 0;
        int temp = stack.pop();
        while(!stack.isEmpty() && temp == stack.peek())
        {
            stack.pop();
            count++;
        }
        if(count == 0) stack.push(temp);
        
        System.out.println(stack);
        if(stack.isEmpty()) return null;

        LinkedListNode node = new LinkedListNode(stack.pop());

        while(! stack.isEmpty())
        {
            LinkedListNode curr = new LinkedListNode(stack.pop());
            curr.next = node;
            node = curr;
        } 

        return node;
    }
}