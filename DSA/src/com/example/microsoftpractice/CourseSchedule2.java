package com.example.microsoftpractice;

import java.util.*;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
        for(int[] edge:prerequisites)
        {
            adj.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
        }
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ;i<numCourses;i++)
        {
            if(inDegree[i] == 0)
            {
                res[index] = i;
                index++;
                queue.offer(i);
            }
        }

        if(queue.isEmpty())  return new int[]{};
        while(!queue.isEmpty())
        {
            int curr = queue.poll();
            for(int ad : adj.get(curr))
            {
                inDegree[ad]--;

                if(inDegree[ad] == 0) 
                {
                    res[index] = ad;
                    index++;
                    queue.offer(ad);
                }
            }
        }

        System.out.println(index);
        if(index != numCourses) return new int[]{};

        return res; 
    }
}