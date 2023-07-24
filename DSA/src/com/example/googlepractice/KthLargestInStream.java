package com.example.googlepractice;

import java.util.*;

public class KthLargestInStream {
    Queue<Integer> pq = new PriorityQueue<>();
    int c;
    
    public KthLargestInStream(int k, int[] nums) {
        for(int i : nums) pq.offer(i);
        c = k;
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size()>c)
        {
            pq.poll();
        }
        return pq.peek();
    }
}