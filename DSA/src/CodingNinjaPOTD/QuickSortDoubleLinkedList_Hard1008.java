package CodingNinjaPOTD;

import java.util.*;

import com.example.datastructure.skeleton.DoubleLinkedListNode;

public class QuickSortDoubleLinkedList_Hard1008 {
    public static DoubleLinkedListNode quickSort(DoubleLinkedListNode head) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        while(head != null)
        {
            list.add(head.data);
            head = head.next;
        }
        quickSort(list , 0 , list.size()-1);

        head = new DoubleLinkedListNode(-1);
        DoubleLinkedListNode tail = new DoubleLinkedListNode(-1);
        DoubleLinkedListNode temp = head;
        for(int i : list)
        {
            DoubleLinkedListNode newDoubleLinkedListNode = new DoubleLinkedListNode(i);
            head.next = newDoubleLinkedListNode;
            newDoubleLinkedListNode.next = tail;
            tail.prev = newDoubleLinkedListNode;
            newDoubleLinkedListNode.prev = head;
            head = newDoubleLinkedListNode; 
        }
        head.next = null;
        return temp.next;
    }

    static void quickSort(List<Integer> list , int start , int end)
    {
        if(start<end)
        {
            int pivot = getPivot(list,start,end);
            quickSort(list,start , pivot-1);
            quickSort(list,pivot+1 , end);
        }
    }

    static int getPivot(List<Integer> list , int start , int end)
    {
        int pivot = list.get(start);
        int i = start;
        int j = end;
        while(i<j)
        {
            while(list.get(i) <=pivot && i<end) i++;
            while(list.get(j) > pivot) j--;

            if(i<j) swap (list , i , j);
        }
        swap(list , start , j);

        return j;
    }

    static void swap(List<Integer> list , int a  , int b)
    {
        int x = list.get(a);
        list.set(a , list.get(b));
        list.set(b , x);
    }
}

