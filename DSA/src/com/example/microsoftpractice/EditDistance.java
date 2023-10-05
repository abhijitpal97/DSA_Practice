package com.example.microsoftpractice;

// https://leetcode.com/problems/edit-distance/description/

public class EditDistance {
	public int editDistance(String s, String t) {
		// Code here
		Integer[][] dp = new Integer[s.length()+1][t.length()+1];
		return lca(s,t,s.length()-1 , t.length()-1 , dp);

	}

	int lca(String s , String t , int  i , int j , Integer[][] dp)
	{
		if(i < 0 ) return j+1;
		if(j < 0 ) return i+1;
		if(dp[i][j] != null) return dp[i][j];

		int l = 0;

		if(s.charAt(0) == t.charAt(0))
		{
			l = lca(s.substring(1) , t.substring(1) , i-1 , j-1 , dp);
		}
		else
		{
			l = 1+Math.min (
					lca(s , t.substring(1) , i , j-1 , dp) , 
					Math.min
					(lca(s.substring(1) , t , i-1 , j , dp),
							lca(s.substring(1) , t.substring(1) , i-1 , j-1 , dp)
							));

		}

		return dp[i][j] = l;
	}
}