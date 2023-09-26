package com.example.amazonpractice;
import java.util.* ;

// https://www.codingninjas.com/studio/problems/is-graph-tree_1115787?leftPanelTab=2

public class IsGraphTree {
    public static boolean isGraphTree(int n, ArrayList<ArrayList<Integer>> edgeList) {
        // Write your code here.

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

		for (int i = 0; i < n; i++)  adj.add(new ArrayList<>());
		
		// Build adjacency list graph
		for (int i = 0; i < edgeList.size(); i++) 
		{
			int u = edgeList.get(i).get(0);
            int v = edgeList.get(i).get(1);
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
               
        int count  = 0;
        boolean[] isVisited = new boolean[n];
        
        for(int i =0 ; i <n ; i++)
        {
            if(!isVisited[i])
            {
                if(dfs(i , adj , n , isVisited , -1)) return false;
                count++;
            }
        }
        return count>1?false:true;
    }

    static boolean dfs(int src , ArrayList<ArrayList<Integer>> edgeList , 
    int n , boolean[] isVisited , int parent)
    {
        isVisited[src] = true;
        
        for(int ad : edgeList.get(src))
        {
            if(!isVisited[ad])
            {
                if(dfs(ad , edgeList , n , isVisited , src)) return true;
            }
            else if(ad != parent) return true; 
        }
        return false;
    }
}