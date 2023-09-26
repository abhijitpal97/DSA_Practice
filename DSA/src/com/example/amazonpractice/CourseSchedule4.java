package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/course-schedule-iv/description/

public class CourseSchedule4 {
	public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
		List<List<Integer>> adj = new ArrayList<>();
		int[] inDegree = new int[numCourses];

		for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
		for(int[] edge : prerequisites)
		{
			adj.get(edge[0]).add(edge[1]);
			inDegree[edge[1]]++;
		}

		boolean[][] preReq = new boolean[numCourses][numCourses];
		Queue<Integer> queue = new LinkedList<>();
		for(int i=0;i<numCourses;i++)
		{
			if(inDegree[i] == 0) queue.offer(i);
		}

		while(!queue.isEmpty())
		{
			int curr = queue.poll();

			for(int i : adj.get(curr))
			{
				preReq[curr][i] = true;
				for(int j=0;j <numCourses ; j++)
				{
					if(preReq[j][curr]) preReq[j][i] = true;
				}
				inDegree[i] -- ;

				if(inDegree[i] == 0) queue.offer(i);
			}
		}

		List<Boolean> list = new ArrayList<>();

		for(int i = 0 ; i<queries.length; i++)
		{
			list.add(preReq[queries[i][0]][queries[i][1]]);
		}

		return list;
	}
}