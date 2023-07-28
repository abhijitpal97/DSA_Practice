package com.example.googlepractice;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length <=1) return 0;
        Arrays.sort(intervals , (a , b) -> a[0]-b[0]);
        int remove = 0;

        int[] temp = intervals[0];
        for(int i =1;i<intervals.length;i++)
        {
            if(intervals[i][0]<temp[1])
            {
                remove++;
                if(intervals[i][1]<temp[1]) temp = intervals[i];
            }
            else
            {
                temp = intervals[i];
            }
        }

        return remove;
    }
}