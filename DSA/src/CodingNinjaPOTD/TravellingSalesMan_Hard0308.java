package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

public class TravellingSalesMan_Hard0308 {
    public static int shortestRoute(int[][] distance) {
        // Write your code here.   
        int city = distance.length;
        boolean[] isVisited = new boolean[city]; 
        int res = dfs(0 , isVisited , distance , city);
        return res;   
    }

    static int dfs(int src , boolean[] isVisited , int[][] distance , int n)
    {
        isVisited[src] = true;

        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i<n ;i++)
        {
            if(! isVisited[i])
            {
                int res = distance[src][i] + dfs(i , isVisited , distance , n);
                min = Math.min(min , res);
            }
        }

        isVisited[src] = false;

        if(min==Integer.MAX_VALUE) return distance[src][0];

        return min;
    }
}