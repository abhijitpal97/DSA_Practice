package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/integer-replacement/description/

class PairReplacement
{
	long num;
	int count;

	PairReplacement(long num , int count)
	{
		this.num=num;
		this.count=count;
	}
}


public class IntegerReplaceMent {
	public int integerReplacement(int n) {
		Queue<PairReplacement> queue = new LinkedList<>();
		queue.offer(new PairReplacement((long) n , 0));

		while(! queue.isEmpty())
		{
			int size = queue.size();

			for(int i = 0; i<size;i++)
			{
				PairReplacement curr = queue.poll();
				long num = curr.num;
				int count = curr.count;

				if(num == 1) return curr.count;
				if(num%2 == 0) queue.offer(new PairReplacement(num/2 , count+1));
				else if(num%2 == 1)
				{
					queue.offer(new PairReplacement(num+1 , count+1));
					if(num-1>0) queue.offer(new PairReplacement(num-1 , count+1));
				}

			}
		}   
		return -1;
	}
}