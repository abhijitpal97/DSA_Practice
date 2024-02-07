package com.example.amazonpractice;

// https://leetcode.com/problems/maximize-distance-to-closest-person/description/

public class MaxDistanceToClosest {
	public int maxDistToClosest(int[] seats) {
		int before = -1;
		int after = 0;
		int max = 1;
		int n = seats.length;

		while(after < n)
		{
			if(seats[after] == 1)
			{
				if(before == -1) max = Math.max(max , after-before-1);

				before = after;
			}
			else max = Math.max(max , (after-before+1)/2);
			after++;
		}
		max = Math.max(max , after-before-1);
		return max;
	}

}