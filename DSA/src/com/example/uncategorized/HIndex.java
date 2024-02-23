package com.example.uncategorized;

// https://leetcode.com/problems/h-index/

public class HIndex {
    public int hIndex(int[] citations) {
        int min = 0;
        int max = citations.length;

        while(min < max)
        {
            int count = 0;
            int mid = (min+max+1)/2;

            for(int i = 0 ; i< citations.length ; i++)
            {
                if(citations[i] >= mid) count++;
            }

            if(count >= mid) min = mid;
            else max = mid-1;
           
        }

        return min;
    }
}