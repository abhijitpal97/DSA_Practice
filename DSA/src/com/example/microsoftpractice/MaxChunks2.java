package com.example.microsoftpractice;

// https://leetcode.com/problems/max-chunks-to-make-sorted-ii

public class MaxChunks2 {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = arr[0];
        right[n-1] = arr[n-1];
        
        for(int i=1;i<n;i++)
        {
            left[i] = Math.max(left[i-1] , arr[i]);
        }
        
        for(int i=n-2;i>=0;i--)
        {
            right[i] = Math.min(right[i+1] , arr[i]);
        }
        
        int chunks = 0;
        
        for(int i = 0; i<n-1; i++)
        {
            if(left[i] <= right[i+1]) chunks++;
        }
        
        return chunks+1;
    }
}