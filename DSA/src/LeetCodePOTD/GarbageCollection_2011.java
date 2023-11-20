package LeetCodePOTD;

import java.util.*;

// https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/description/

public class GarbageCollection_2011 {
	public int garbageCollection(String[] garbage, int[] travel) {
		long total = 0;
		long curr = 0;

		total += garbage[0].length();
		List<Integer> garbageIndices = new ArrayList<>(Arrays.asList(-1,-1,-1));

		for(int i=1;i<garbage.length;i++)
		{
			total += garbage[i].length();

			if(garbage[i].contains("M")) garbageIndices.set(0 , i-1);
			if(garbage[i].contains("P")) garbageIndices.set(1 , i-1);
			if(garbage[i].contains("G")) garbageIndices.set(2 , i-1);
		}

		for(int i=0;i<travel.length;i++)
		{
			curr += travel[i];

			for(int j=0;j<3;j++)
			{
				if(garbageIndices.get(j) == i) total += curr;
			}
		}

		return (int) total;
	}
}