package LeetCodePOTD;

import java.util.*;

// https://leetcode.com/problems/count-nice-pairs-in-an-array

public class CountNicePairs_2111 {
	public int countNicePairs(int[] nums) {
		int MOD = 1000000007;
		int n = nums.length;
		int count = 0;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<n;i++) map.put(nums[i] , reverseNum(nums[i]));

		for(int i=0;i<n-1;i++)
		{
			for(int j = i+1;j<n;j++)
			{
				if(isNice(nums[i],nums[j] , map)) count = (count+1)%MOD;
			}
		}

		return count;
	}

	boolean isNice(int a , int b, Map<Integer,Integer> map)
	{
		int revb = map.get(b);
		int reva = map.get(a);
		int sum1 = a+revb;
		int sum2 = b+reva;
		//System.out.println(a + " "+b+" -reva- "+reva+" -revb- "+revb);
		return sum1 == sum2;
	}

	int reverseNum(int a)
	{
		//42
		int number = a, reverse = 0;  
		while(number != 0)   
		{  
			int remainder = number % 10;  
			reverse = reverse * 10 + remainder;  
			number = number/10;  
		}
		return reverse;  
	}

	// Optimized - O(N)

	public int countNicePairsOpt(int[] nums) {
		final int mod = 1000000007;

		int len = nums.length;
		for(int i=0;i<len;i++) nums[i] = nums[i] - reverseNum(nums[i]);
		Arrays.sort(nums);
		long count = 0;

		for(int i=0;i<len-1;i++) {
			long cont = 1;
			while(i<len-1 && nums[i]==nums[i+1]) {
				cont++;
				i++;
			}
			count = (count%mod + (cont*(cont-1))/2)%mod;
		}

		return (int)count;
	}
}