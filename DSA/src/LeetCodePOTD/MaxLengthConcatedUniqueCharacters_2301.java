package LeetCodePOTD;

import java.util.*;

// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/

public class MaxLengthConcatedUniqueCharacters_2301 {
	int ct = Integer.MIN_VALUE;
	public int maxLength(List<String> arr) {
		ct = Integer.MIN_VALUE;
		function(arr , "" , 0 , arr.size() , 0);
		return ct;
	}

	void function(List<String> arr , String str , int index , int n , int count)
	{
		if(index == n)
		{
			//System.out.println(str);
			if(isUnique(str))
			{
				ct = Math.max(ct , str.length());
				System.out.println(ct);
			}
			return;
		}


		function(arr , str+arr.get(index) , index+1 , n , count+1);
		function(arr , str , index+1 , n , count);
	}

	boolean isUnique(String str)
	{
		Set<Character> set = new HashSet<>();
		for(char ch : str.toCharArray())
		{
			if(! set.add(ch)) return false;
		}
		//System.out.println(str);
		return true;
	}
}