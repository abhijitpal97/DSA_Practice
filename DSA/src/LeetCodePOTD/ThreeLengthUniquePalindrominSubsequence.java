package LeetCodePOTD;

import java.util.*;

// https://leetcode.com/problems/unique-length-3-palindromic-subsequences/

public class ThreeLengthUniquePalindrominSubsequence {
	public int countPalindromicSubsequence(String s) {
		Set<String> set = new HashSet<>();
		function(s , "" , 0 , s.length() , set);
		return set.size();
	}

	void function(String s , String str , int index , int n, Set<String> set)
	{
		if(str.length() == 3)
		{
			//System.out.println(str);
			if(isPalindromic(str)) set.add(str);
		}
		if(index>=n) return;

		function(s , str+s.charAt(index) , index+1 , n , set);
		function(s , str , index+1 , n , set);
	}

	boolean isPalindromic(String str)
	{
		if(str.charAt(0) == str.charAt(2)) return true;
		return false;
	}

	// Binary Search - Count

	public int countPalindromicSubsequenceSearch(String s) {
		int result = 0;
		Set<Character> unique = new HashSet<>();

		for(char ch : s.toCharArray()) unique.add(ch);

		for(char ch : unique)
		{
			int start = s.indexOf(ch);
			int last = s.lastIndexOf(ch);

			if(start<last)
			{
				Set<Character> palSet = new HashSet<>();

				for(int i=start+1;i<last;i++)
				{
					char curr = s.charAt(i);
					palSet.add(curr);
				}

				result += palSet.size();
			}
		}

		return result;
	}

}