package com.example.gspractice;

import java.util.*;

public class SortestSubArraySumAtleastK {
    public int shortestSubarray(int[] nums, int k) {
        long[] arr = new long[nums.length+1];

        for(int i=0;i<nums.length;i++)
        {
            arr[i+1] = arr[i]+nums[i];

            if(nums[i] >= k) return 1;
        }

        int res = Integer.MAX_VALUE;

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0;i<=nums.length;i++)
        {
            while(! dq.isEmpty() && arr[i] <= arr[dq.getLast()]) dq.removeLast();
            while(! dq.isEmpty() && arr[i] - arr[dq.peek()] >= k) res = Math.min(res , i-dq.poll());
            dq.offer(i);
        }

        return res==Integer.MAX_VALUE?-1:res;
    }
}