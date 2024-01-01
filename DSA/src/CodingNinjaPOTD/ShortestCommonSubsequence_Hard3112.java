package CodingNinjaPOTD;

import java.util.Arrays;

// https://leetcode.com/problems/shortest-common-supersequence/description/

public class ShortestCommonSubsequence_Hard3112 {
	String result = "";
	int max = Integer.MAX_VALUE;

	//Recursion

	public String shortestCommonSupersequence(String str1, String str2) {
		result = "";
		max = Integer.MAX_VALUE;
		function(str1,str2,"");
		return result;
	}

	void function(String a, String b , String curr)
	{
		if(a.length() == 0)
		{
			curr += b;
			if(curr.length() < max)
			{
				max = curr.length();
				result = curr;
			}
			return;
		}

		if(b.length() == 0)
		{
			curr += a;
			if(curr.length() < max)
			{
				max = curr.length();
				result = curr;
			}
			return;
		}

		if(a.charAt(0) == b.charAt(0))
		{
			function(a.substring(1) , b.substring(1) , curr+a.charAt(0));
		}

		function(a.substring(1) , b , curr+a.charAt(0));
		function(a , b.substring(1) , curr+b.charAt(0));
	}

	// Memorization
	public String shortestCommonSupersequenceMemo(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();

		int[][] dp = new int[n+1][m+1];

		for(int rows[]:dp){
			Arrays.fill(rows,0);
		}
		int len = lcs(n,m,str1,str2,dp);

		int i=n;
		int j=m;
		String ans="";
		while(i>0 && j>0){
			if(str1.charAt(i-1)==str2.charAt(j-1)){
				ans+=str1.charAt(i-1);
				i--;
				j--;
			}else if(dp[i-1][j]>dp[i][j-1]){
				ans+=str1.charAt(i-1);
				i--;
			}else{
				ans+=str2.charAt(j-1);
				j--;
			}
		}
		while(i>0){
			ans+=str1.charAt(i-1);
			i--;
		}
		while(j>0){
			ans+=str2.charAt(j-1);
			j--;
		}
		//System.out.println(ans);
		String ans2=new StringBuilder(ans).reverse().toString();
		return ans2;
	}

	public int lcs(int n, int m, String str1, String str2,int dp[][]){
		if(n==0 || m==0){
			return 0;
		}
		if(dp[n][m]!=0){
			return dp[n][m];
		}
		if(str1.charAt(n-1)==str2.charAt(m-1)){
			return dp[n][m]=1+lcs(n-1,m-1,str1,str2,dp);
		}
		else{
			int a=lcs(n-1,m,str1,str2,dp);
			int b=lcs(n,m-1,str1,str2,dp);
			return dp[n][m]=Math.max(a,b);
		}
	}
}