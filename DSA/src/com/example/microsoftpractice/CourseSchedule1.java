package com.example.microsoftpractice;

import java.util.*;

// https://leetcode.com/problems/course-schedule/description/

public class CourseSchedule1 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] inDegree = new int[numCourses];

		List<List<Integer>> adj = new ArrayList<>();
		for(int i = 0 ; i<numCourses ; i++) adj.add(new ArrayList<>()); 
		for(int[] edge : prerequisites)
		{
			adj.get(edge[0]).add(edge[1]);
			inDegree[edge[1]]++;
		}
		Queue<Integer> queue = new LinkedList<>();

		for(int i=0;i<numCourses;i++)
		{
			if(inDegree[i] == 0 ) queue.offer(i);
		}

		if(queue.isEmpty()) return false;
		int count = 0;
		while(!queue.isEmpty())
		{
			int curr = queue.poll();
			count++;
			for(int i : adj.get(curr))
			{
				inDegree[i]--;
				if(inDegree[i] == 0) queue.offer(i);
			}
		}

		return count == numCourses;
	}
}