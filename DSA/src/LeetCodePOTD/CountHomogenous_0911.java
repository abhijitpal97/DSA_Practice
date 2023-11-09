package LeetCodePOTD;

import java.util.*;

// https://leetcode.com/problems/count-number-of-homogenous-substrings/description/

public class CountHomogenous_0911 {

	// Brute Force - O(n^2)
	public int countHomogenous(String s) {
		int MOD = 1000000007;
		int count = 0;
		for(int i=0;i<s.length();i++)
		{
			String str = "";
			for(int j = i;j<s.length();j++)
			{
				str += s.charAt(j);
				if(isHomogenous(str))
				{
					count++;
					count = count%MOD;
				}
				else break;
			}
		}
		return count;
	}

	boolean isHomogenous(String str)
	{
		Set<Character> set = new HashSet<>();

		for(char ch : str.toCharArray())
		{
			set.add(ch);
			if(set.size()>1) return false;
		}

		return true;
	}

	// Optimized - SlidingWindow O(n)

	public int countHomogenousOpt(String s) {
		int left = 0;
		long res = 0;
		int MOD = 1000000007;

		for(int right = 0; right<s.length(); right++)
		{
			if(s.charAt(left) == s.charAt(right)) res += right-left+1;
			else
			{
				res +=1;
				left = right;
			}
		}

		return (int)(res%MOD);
	}
}