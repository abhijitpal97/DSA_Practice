package com.example.amazonpractice;

import java.util.*;

public class KeyAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] isVisited = new boolean[n];
        n--;
        isVisited[0] = true;
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(rooms.get(0));

        while(! queue.isEmpty())
        {
            List<Integer> curr = queue.poll();
            
            for(int i : curr)
            {
               if(!isVisited[i])
               {
                    queue.offer(rooms.get(i));
                    isVisited[i] = true;
                    n--;
               }
            }
        }

        return n==0;
    }
}