package com.example.microsoftpractice;

import java.util.*;

public class MedianFinder {
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;
    public MedianFinder() {
         minHeap = new PriorityQueue<>();
         maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num<maxHeap.peek()) maxHeap.offer(num);
        else minHeap.offer(num);

        balanceHeap();
        
    }

    void balanceHeap()
    {
        if(maxHeap.size()-minHeap.size()>1) minHeap.offer(maxHeap.poll());
        else if(minHeap.size() > maxHeap.size()) maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
        if(maxHeap.isEmpty()) return 0;
        if(maxHeap.size() == minHeap.size()) return (maxHeap.peek()+minHeap.peek())/2.0;
        return maxHeap.peek();
    }
}