package LeetCodePOTD;

import java.util.*;

// https://leetcode.com/problems/furthest-building-you-can-reach/submissions/1177496003/
public class FurthestBuildReachable_1702 {

	// Recursion Approach
	int max = 0;
	public int furthestBuilding(int[] heights, int bricks, int ladders) {
		int n = heights.length;
		if(n==0) return 0;
		solve(heights,bricks,ladders,0,n,0);
		return max;
	}

	private void solve(int[] heights,int bricks,int ladders,int idx,int n,int count){
		if(idx==n-1){
			max = Math.max(count,max);
			return;
		}

		if(heights[idx]>=heights[idx+1]){
			solve(heights,bricks,ladders,idx+1,n,count+1);
		}
		else{
			int diff = heights[idx+1]-heights[idx];
			if(bricks>=diff) solve(heights,bricks-diff,ladders,idx+1,n,count+1);
			if(ladders>0)  solve(heights,bricks,ladders-1,idx+1,n,count+1);
		}
		max = Math.max(count,max);
	}

	// Queue Approach
	public int furthestBuildingQueue(int[] heights, int bricks, int ladders) {
		Queue<Integer> pq = new PriorityQueue<>();

		for(int i=0 ; i<heights.length-1 ; i++)
		{
			int diff = heights[i+1]-heights[i];
			if(diff>0)
			{
				pq.offer(diff);
				if(pq.size()>ladders) bricks -= pq.poll();
				if(bricks<0) return i;
			}
		}

		return heights.length-1;
	}
}