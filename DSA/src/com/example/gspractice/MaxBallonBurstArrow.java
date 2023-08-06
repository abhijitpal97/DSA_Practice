package com.example.gspractice;

import java.util.Arrays;

public class MaxBallonBurstArrow {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int last = points[0][1];
        int minArrow = 1;

        for(int i=1;i<points.length;i++)
        {
            if(points[i][0] > last)
            {
                minArrow++;
                last = points[i][1];
            }
        }

        return minArrow;
    }
}