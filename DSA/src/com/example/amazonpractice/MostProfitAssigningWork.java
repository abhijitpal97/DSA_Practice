package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/most-profit-assigning-work/

class ProfitAssignPair
{
	int diff;
	int profit;

	ProfitAssignPair(int diff , int profit)
	{
		this.diff=diff;
		this.profit=profit;
	}
} 


public class MostProfitAssigningWork {
	public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
		Queue<ProfitAssignPair> queue = new PriorityQueue<>((a,b) -> b.profit-a.profit);
		Arrays.sort(worker);

		for(int i = 0 ; i<difficulty.length ; i++) queue.offer(new ProfitAssignPair(difficulty[i] , profit[i]));

		int sum = 0;
		for(int i = worker.length-1 ; i>= 0 ; i--)
		{
			if(queue.isEmpty()) continue;

			while(! queue.isEmpty())
			{
				boolean validated = false;
				ProfitAssignPair p1 = queue.poll();
				if(p1.diff<=worker[i])
				{
					sum +=p1.profit;
					queue.offer(p1);
					validated = true;
				} 
				if(validated) break;
			}
		}

		return sum;
	}
}