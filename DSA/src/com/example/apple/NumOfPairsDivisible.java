package com.example.apple;

import java.util.*;

public class NumOfPairsDivisible {
	public int numPairsDivisibleBy60(int[] time) {
		int count = 0;

		for(int i = 0 ; i < time.length ; i++)
		{
			for(int j = i+1 ; j < time.length ; j++)
			{
				int duration = time[i] + time[j] ; 
				if(duration%60 == 0)
				{
					//System.out.println(i + " - " + j );
					count++;
				} 
			}
		}

		return count;
	}

	// Time Complexity Optimization

	public int numPairsDivisibleBy60Optimized(int[] time) {
		int res =0;
		Map<Integer, Integer> hm = new HashMap<>();
		for (int song : time) {
			int rem = song % 60;
			int req = (60-rem)%60;

			res += hm.getOrDefault(req , 0);

			hm.put(rem , hm.getOrDefault(rem , 0)+1);
		}

		return res;
	}
}