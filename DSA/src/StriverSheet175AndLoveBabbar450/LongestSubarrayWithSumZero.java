package StriverSheet175AndLoveBabbar450;
import java.io.*;
import java.util.* ;

import java.util.ArrayList;

// https://www.codingninjas.com/studio/problems/longest-subset-zero-sum_920321

public class LongestSubarrayWithSumZero {

	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {

		// Write your code here.
		Map<Integer,Integer> map = new HashMap<>();
		map.put(0 , -1);
		int longest = 0;
		int currS = 0;
		for(int i=0;i<arr.size();i++)
		{
			currS += arr.get(i);
			if(map.containsKey(currS))
			{
				longest = Math.max(longest , (i-map.get(currS)));
			}
			else map.put(currS , i);
		}
		return longest;
	}
}