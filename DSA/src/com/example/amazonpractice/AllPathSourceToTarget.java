package com.example.amazonpractice;

import java.util.*;

public class AllPathSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int row = graph.length;
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(graph , 0 , row-1, list , result);
        return result;
    }

    void dfs(int[][] graph , int curr , int dest , List<Integer> list , List<List<Integer>> result)
    {
        if(curr == dest)
        {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i : graph[curr])
        {
            list.add(i);
            dfs(graph , i , dest , list , result);
            list.remove(list.size()-1);
        }
    }
}