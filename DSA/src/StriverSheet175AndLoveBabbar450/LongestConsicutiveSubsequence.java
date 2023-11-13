package StriverSheet175AndLoveBabbar450;

import java.util.*;

// https://leetcode.com/problems/longest-consecutive-sequence/

public class LongestConsicutiveSubsequence{

	// TC -> N+NlogN
	public int longestConsecutive(int[] nums) {
		// Write your code here.
		List<Integer> list = new ArrayList<>();
		for(int i : nums)
		{
			if(! list.contains(i)) list.add(i);
		}
		Collections.sort(list); 
		int longest = 0;
		int N= list.size();
		for(int i=0;i<N;i++)
		{
			int temp = 1;
			int curr = list.get(i); // 0
			while((i+1 < N) && (curr+1 == list.get(i+1)))
			{
				curr = list.get(i+1);
				i++;
				temp++;
			}
			longest = Math.max(longest , temp);
		}

		return longest;

	}

	// TC -> N
	public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
		// Write your code here.
		Set<Integer> set = new HashSet<>();
		for(int i : arr) set.add(i);

		int longest = 0;

		for(int i : set)
		{
			int count = 1;
			if(! set.contains(i-1))
			{
				while(set.contains(i+1))
				{
					count++;
					i++;
				}
			}
			longest = Math.max(longest , count);
		}

		return longest;
	}
}