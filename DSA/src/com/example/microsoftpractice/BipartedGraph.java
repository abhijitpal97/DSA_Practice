package com.example.microsoftpractice;

import java.util.LinkedList;
import java.util.Queue;

public class BipartedGraph {
    public boolean isBipartite(int[][] graph) {
        int row = graph.length;
        int[] isVisited= new int[row];
        Queue<Integer> queue = new LinkedList<>();

        for(int c =0 ; c<row; c++)
        {
            if(isVisited[c] == 0)
            {
                queue.offer(c);
                isVisited[c] = -1;

                while(! queue.isEmpty())
                {
                    int curr = queue.poll();

                    for(int i : graph[curr])
                    {
                        if(isVisited[i] == isVisited[curr]) return false;
                        if(isVisited[i] == 0)
                        {
                        queue.offer(i);
                        isVisited[i] = -1 * isVisited[curr];
                        }
                    }
                }
            }
        }
        return true;

    }
}