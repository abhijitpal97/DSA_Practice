package com.example.ciscopractice;

import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        List<List<Integer>> result = new ArrayList<>();

       int[] interval = new int[2];
        for(int i = 0 ; i<intervals.length; i++)
        {
            if(result.isEmpty()) 
            {
                interval[0] = intervals[i][0];
                interval[1] = intervals[i][1];
            }
            else
            {
                if(intervals[i][0]<=interval[1])
                {
                    result.remove(result.size()-1);
                    interval[0] = Math.min(intervals[i][0] ,interval[0]);
                    interval[1] = Math.max(intervals[i][1] ,interval[1]);
                }
                else
                {
                    interval[0] = intervals[i][0];
                    interval[1] = intervals[i][1];
                }
            }

            result.add(new ArrayList<>(Arrays.asList(interval[0] , interval[1])));
        }

        int[][] res = new int[result.size()][2];
        
        for(int i=0;i<result.size();i++)
        {
            res[i][0] = result.get(i).get(0);
            res[i][1] = result.get(i).get(1);
        }

        return res;
    }
}