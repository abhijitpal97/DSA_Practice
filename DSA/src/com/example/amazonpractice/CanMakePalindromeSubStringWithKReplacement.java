package com.example.amazonpractice;

import java.util.*;

public class CanMakePalindromeSubStringWithKReplacement {
	public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
		List<Boolean> list = new ArrayList<>();
		for(int[] query : queries)
		{
			list.add(checkPalindrome(s , query));
		}
		return list;
	}

	boolean checkPalindrome(String str , int[] query)
	{
		int start = query[0];
		int end = query[1];
		int replacement = query[2];

		str = str.substring(start,end+1);
		System.out.println(str + " - "+start+" - "+end+" - "+replacement);
		int low = 0;
		int high = str.length()-1;
		while(low<=high)
		{
			if(str.charAt(low) == str.charAt(high))
			{
				low++;
				high--;
			}
			else if(replacement>0)
			{
				replacement--;
				low++;
				high--;
			}
			else return false;
		}
		return true;
	}
}