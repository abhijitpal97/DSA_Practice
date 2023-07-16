package com.example.amazonpractice;

import java.util.*;

public class ProcessQueriesUsingListArray {
    public int[] processQueries(int[] queries, int m) {
        List<Integer> list = new ArrayList<>();
        int[] result = new int[queries.length];
        for(int i=1;i<=m;i++) list.add(i);

        for(int i=0;i<queries.length;i++)
        {
            int curr = queries[i];
            result[i] = list.indexOf(curr);
            list.remove(list.indexOf(curr));
            list.add(0 , curr);
        }

        return result;
    }
}