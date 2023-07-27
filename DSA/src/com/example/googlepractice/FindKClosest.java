package com.example.googlepractice;

import java.util.*;

class ClosestPair implements Comparable<ClosestPair>
{
    int dist;
    int val;

    ClosestPair(int dist , int val)
    {
        this.dist = dist;
        this.val = val;
    }

    public int compareTo(ClosestPair that)
    {
        if(this.dist == that.dist) return this.val-that.val;
        return this.dist - that.dist;
    }
}


public class FindKClosest {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Queue<ClosestPair> pq = new PriorityQueue<>();

        for(int i=0; i<arr.length; i++)
        {
            pq.offer(new ClosestPair(Math.abs(x - arr[i]) , arr[i]));
        }

        List<Integer> list = new ArrayList<>();
        if(pq.size()<k) return list;

        while(k > 0)
        {
            list.add(pq.poll().val);
            k--;
        }

        Collections.sort(list);
        return list;
    }
}