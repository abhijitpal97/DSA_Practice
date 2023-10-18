package LeetCodePOTD;

import java.util.*;

public class ParallelCourse3_1810 {
	public int minimumTime(int n, int[][] relations, int[] time) {
		List<List<Integer>> adj = new ArrayList<>();
		int[] inDegree = new int[n+1];
		for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

		for(int[] rel : relations)
		{
			int src = rel[0];
			int dest = rel[1];

			adj.get(src).add(dest);
			inDegree[dest]++;
		}

		return calculateTime(n , time , adj , inDegree);
	}

	int calculateTime(int n , int[] time , List<List<Integer>> adj , int[] inDegree)
	{
		int[] waitTime = new int[n+1];
		Queue<int[]> queue = new LinkedList<>();
		int maxWait = 0;

		for(int i=1;i<=n;i++)
		{
			if(inDegree[i] == 0)
			{
				queue.offer(new int[]{time[i-1] , i});
				waitTime[i] = time[i-1];
			}
		}

		while(! queue.isEmpty())
		{
			int[] curr = queue.poll();
			int currCourseTime = curr[0];
			maxWait = Math.max(maxWait , currCourseTime);
			int currCourse = curr[1];

			for(int child : adj.get(currCourse))
			{
				inDegree[child]--;
				waitTime[child] = Math.max(time[child-1]+waitTime[currCourse] , waitTime[child]);

				if(inDegree[child] == 0)
				{
					queue.offer(new int[]{waitTime[child] , child});
				}
			}
		}

		return maxWait;
	}
}