package StriverSheet175AndLoveBabbar450;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/longest-repeating-subsequence_1062697

public class LongestRepeatingSubsequence {
	public static int LRS(String str) {
		// Write your code here.
		int n = str.length();
		String rev = str;
		Integer[][] dp = new Integer[n+1][n+1];
		return lcs(str , rev , n , n , dp);
	}

	static int lcs(String s , String t , int n , int m , Integer[][] dp)
	{
		if(n==0 || m==0) return 0;
		if(dp[n][m] != null) return dp[n][m];

		int x = 0;
		int y = 0;
		int z = 0;

		if(s.charAt(n-1) == t.charAt(m-1) && n!=m)
		{
			x = 1+lcs(s , t , n-1 , m-1 , dp);
		}
		else
		{
			y = lcs(s , t , n-1 , m , dp);
			z = lcs(s , t , n , m-1 , dp);
		}

		return dp[n][m] = Math.max(x , Math.max(y,z));

	}
}