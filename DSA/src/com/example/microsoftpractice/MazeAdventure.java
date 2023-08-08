package com.example.microsoftpractice;

import java.util.*;

public class MazeAdventure
{
    int count = 0;
    int max = 0;
    public int[] FindWays(int[][] matrix)
    {
        // Code here
        int row = matrix.length;
        int col = matrix[0].length;
        count = 0 ;
        max = 0;
        boolean[][] isVisited = new boolean[row][col];
        
        dfs(0 , 0 , row-1 , col-1 , matrix , isVisited , row , col,0);
        
        return new int[]{count , max};
        
    }
    
    void dfs(int srcR , int srcC , int destR , int destC , int[][] matrix ,
    boolean[][] isVisited , int row , int col,int sum)
    {
        if(srcR == destR && srcC == destC) 
        {
            count++;
            max = Math.max(max , sum+matrix[srcR][srcC]);
            return;
        }
        
        if(srcR<0 || srcR>=row || srcC<0 || srcC>=col || isVisited[srcR][srcC]) return;
        isVisited[srcR][srcC] = true;
        
        if(matrix[srcR][srcC] == 1) dfs(srcR ,srcC+1 , destR,destC , matrix , isVisited, row , col,sum+matrix[srcR][srcC]);
        else if(matrix[srcR][srcC] == 2) dfs(srcR+1 ,srcC , destR,destC , matrix , isVisited, row , col,sum+matrix[srcR][srcC]);
        else if(matrix[srcR][srcC] == 3) 
        {
            dfs(srcR ,srcC+1 , destR,destC , matrix , isVisited, row , col,sum+matrix[srcR][srcC]);
            dfs(srcR+1 ,srcC , destR,destC , matrix , isVisited, row , col,sum+matrix[srcR][srcC]);
        }
        
        isVisited[srcR][srcC] = false;
    }
    
    
    // Memorization
    
    public int[] FindWaysMemo(int[][] matrix)
    {
        // Code here
        int row = matrix.length;
        int col = matrix[0].length;
        Map<String,int[]> map = new HashMap<>();
        
        return dfs(0 , 0 , row-1 , col-1 , matrix ,map , row , col);
        
    }
    
    int[] dfs(int srcR , int srcC , int destR , int destC , int[][] matrix , 
    Map<String,int[]> map , int row , int col)
    {
        if(srcR == destR && srcC == destC) 
        {
            return new int[]{1 , matrix[srcR][srcC]};
        }
        
        if(srcR<0 || srcR>=row || srcC<0 || srcC>=col) return new int[]{0,0};
        
        String key = srcR+"_"+srcC;
        if(map.get(key) != null) return map.get(key);
        
        int[] right = new int[]{0,0};
        int[] down = new int[]{0,0};
        if(matrix[srcR][srcC] == 1) 
        {
            right = dfs(srcR ,srcC+1 , destR,destC , matrix , map, row , col);
        }
        else if(matrix[srcR][srcC] == 2)
        {
            down = dfs(srcR+1 ,srcC , destR,destC , matrix ,map ,  row , col);
        }
        else if(matrix[srcR][srcC] == 3) 
        {
            right = dfs(srcR ,srcC+1 , destR,destC , matrix , map, row , col);
            down = dfs(srcR+1 ,srcC , destR,destC , matrix ,map ,  row , col);
        }
        
        int val =  Math.max(right[1] , down[1]);
        int[] adj = new int[]{right[0]+down[0] , val==0?0:(val + matrix[srcR][srcC])};
        map.put(key , adj);
        
        return adj;
    }
}