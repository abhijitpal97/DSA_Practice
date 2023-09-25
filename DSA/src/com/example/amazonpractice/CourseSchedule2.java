package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/course-schedule-ii/description/

public class CourseSchedule2 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<List<Integer>> adj = new ArrayList<>();
		int[] inDegree = new int[numCourses];
		for(int i =0 ; i<numCourses ; i++) adj.add(new ArrayList<>());

		for(int[] pre : prerequisites)
		{
			adj.get(pre[1]).add(pre[0]);
			inDegree[pre[0]]++;
		}
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		for(int i= 0 ; i< numCourses ; i++)
		{
			if(inDegree[i] == 0)
			{
				queue.add(i);
				list.add(i);
			}
		}

		while(! queue.isEmpty())
		{
			int curr = queue.poll();

			for(int ad : adj.get(curr))
			{
				inDegree[ad]--;

				if(inDegree[ad] == 0)
				{
					queue.offer(ad);
					list.add(ad);
				}
			}
		}
		if(list.size() != numCourses) return new int[]{};

		int[] res = new int[numCourses];

		for(int i=0;i<list.size();i++)
		{
			res[i]= list.get(i);
		}

		return res;
	}
}