package com.example.googlepractice;

import java.util.*;

import com.example.datastructure.skeleton.LinkedListNode;

public class SplitLinkedListArray {
	public static void main(String[] args)
	{
		LinkedListNode one = new LinkedListNode(1);
		LinkedListNode two = one;
		for(int i=0;i<9;i++)
		{
			two.next = new LinkedListNode(i+2);
			two = two.next;
		}
		
		splitListToParts(one, 3);
			
	}
    public static LinkedListNode[] splitListToParts(LinkedListNode head, int k) {
        LinkedListNode[] solution = new LinkedListNode[k];
        if(head == null) return solution;
        int count=0;
        LinkedListNode temp= head;

        while(temp !=null)
        {
            count++;
            temp=temp.next;
        }
        List<LinkedListNode> result= new ArrayList<>();
        if(count<k)
        {
            int index = 0;
            while(head != null)
            {
                result.add(index , new LinkedListNode(head.val));
                head = head.next;
                index++;
            }
        }
        else
        {
            int perNode = count/k;
            int rem = count%k;
            int index = 0;
            while(head !=null)
            {
                int local = perNode;
                LinkedListNode res = new LinkedListNode(-1);
                temp = res;
                while(local != 0)
                {
                    temp.next = new LinkedListNode(head.val);
                    head = head.next;
                    temp=temp.next;
                    local--;
                }
                if(rem != 0)
                {
                    temp.next = new LinkedListNode(head.val);
                    head = head.next;
                    temp=temp.next;
                    rem--;
                }

                result.add(index , res.next);
                index++;
            }
        }

        for(int i=0;i<result.size();i++)
        {
            solution[i] = result.get(i);
        }

        return solution;
        
    }
}