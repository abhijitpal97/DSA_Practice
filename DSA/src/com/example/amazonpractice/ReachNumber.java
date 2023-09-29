package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/reach-a-number/description/

class ReachTuple
{
	int index ;
	int iVal;
	int step;

	ReachTuple(int index , int iVal , int step)
	{
		this.index=index;
		this.iVal=iVal;
		this.step=step;
	}
}


public class ReachNumber {
	public int reachNumber(int target) {
		Queue<ReachTuple> queue = new LinkedList<>();
		queue.offer(new ReachTuple(0,0,0));

		while(! queue.isEmpty())
		{
			int size = queue.size();

			for(int i = 0;i<size;i++)
			{
				ReachTuple tp = queue.poll();
				int index = tp.index;
				int iVal=tp.iVal;
				int step = tp.step;
				if(index == target) return step;

				int newiVal = iVal+1;

				int left = index-newiVal;
				int right = index+newiVal;

				queue.offer(new ReachTuple(left , newiVal,step+1));
				queue.offer(new ReachTuple(right , newiVal,step+1));
			}

		}

		return -1;
	}
}