package com.example.googlepractice;

import java.util.*;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int fresh = 0;
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0 ;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j] == 2) queue.offer(new int[]{i , j});
                else if(grid[i][j] == 1) fresh++;
            }
        }

        if(fresh == 0) return 0;
        if(queue.isEmpty()) return -1;
        int time=0;
        while(! queue.isEmpty())
        {
            int size = queue.size();
            time++;
            for(int i = 0 ;i<size;i++)
            {
                int[] curr = queue.poll();
                for(int[] dir : dirs)
                {
                    int cR = dir[0]+curr[0];
                    int cC = dir[1]+curr[1];
                    if(cR>=0 && cR<row && cC>=0 && cC<col && grid[cR][cC] == 1)
                    {
                        queue.offer(new int[]{cR,cC});
                        grid[cR][cC] = 2;
                        fresh--;

                        if(fresh == 0) return time;
                    }
                }
            }
        }

        return -1;
    }
}