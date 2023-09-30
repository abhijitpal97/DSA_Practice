package com.example.apple;

import java.util.*;

// https://leetcode.com/problems/boats-to-save-people/description/

public class BoatToSavePeople {
	public static void main(String[] args)
	{
		int  res = numRescueBoats(
				new int[] {3,5,3,4} , 3);
		System.out.println(res);
	}

	public static int numRescueBoats(int[] people, int limit) {
		Arrays.sort(people);
		int end = people.length-1;
		int start = 0;
		int boat = 0;
		while(start<=end)
		{
			int sum = people[start]+people[end];

			if(sum<=limit)
			{
				boat ++;
				start++;
				end--;
			}
			else
			{
				boat++;
				end--;
			}     
		}

		return boat;
	}
}
// 1 2 3 5 6 7 8 (10)