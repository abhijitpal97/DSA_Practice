package com.example.microsoftpractice;

import java.util.*;

public class MaxPointsInaLineSlope {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n<3) return n;

        int max = 1;

        for(int i=0;i<n;i++)
        {
           
            Map<Double,Integer> map = new HashMap<>();

            for(int j= 0;j<i;j++)
            {
                double slope = Double.MIN_VALUE;
                int yDiff = points[i][1] - points[j][1];
                int xDiff = points[i][0] - points[j][0];
                if(xDiff != 0) slope  = yDiff / (double)xDiff;
                map.put(slope , map.getOrDefault(slope , 0)+1);
                max = Math.max(max , map.get(slope));
            }
        }

        return max+1;
    }
}