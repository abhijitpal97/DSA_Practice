package com.example.uncategorized;

import java.util.*;

// https://leetcode.com/problems/parallel-courses-ii/description/

class GNode{
	int indegrees;
	List<Integer> outNodes;
	public GNode(){
		indegrees = 0;
		outNodes = new ArrayList<Integer>();
	}
}


public class ParallelCoursesHard2 {
	public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
		// No dependency case
		if(dependencies.length == 0)
			return n % k == 0 ? n / k : n / k + 1;

		// 1) Initialize graph
		HashMap<Integer, GNode> graph = new HashMap<Integer, GNode>();
		for(int i = 1; i <= n; i++){
			graph.put(i, new GNode());
		}
		for(int[] relation : dependencies){
			graph.get(relation[1]).indegrees += 1;
			graph.get(relation[0]).outNodes.add(relation[1]);
		}
		// Prepare a priroityqueue for topological sort and choose nodes(whose indegrees=0) with larger outdegrees first
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
			public int compare(Integer c1, Integer c2){
				return graph.get(c2).outNodes.size() - graph.get(c1).outNodes.size();
			}
		});

		// 2) Collect all the courses without prerequisite
		for(int i = 1; i <= n; i++)
			if(graph.get(i).indegrees == 0)
				pq.add(i);

		// 3) Topological sort, 
		int take = 0, ans = 0;
		while(!pq.isEmpty()){
			Queue<Integer> nextq = new LinkedList<>();
			// Start taking courses for a semester
			while(take < k && !pq.isEmpty()){
				int course = pq.poll();
				for(int nextCourse : graph.get(course).outNodes){
					GNode node = graph.get(nextCourse);
					node.indegrees--;
					if(node.indegrees == 0)
						nextq.add(nextCourse);
				}
				take++;
			}
			// End taking courses for a semester
			take = 0;
			ans++;
			for(int course : nextq)
				pq.add(course);    
		}
		return ans;
	}
}