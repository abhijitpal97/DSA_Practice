package CodingNinjaPOTD;

// https://www.codingninjas.com/studio/problems/k-palindrome_2434296

public class KRemovalPalindrome_Hard2511 {
	public static boolean isPalindrome(int k, String str) {
		// Write your code here.
		int n = str.length();
		Integer[][] dp = new Integer[n+1][n+1];
		String cpy = "";
		for(int i=n-1;i>=0;i--) cpy += str.charAt(i);
		int ans =  function(str , cpy , n , n,dp);

		if(ans<=2*k) return true;
		return false;
	}

	static int function(String str , String cpy , int start , int end,Integer[][] dp)
	{
		if(start == 0) return end;
		if(end == 0) return start;		
		if(dp[start][end] != null) return dp[start][end];


		int ans = 0;

		if(str.charAt(start-1) == cpy.charAt(end-1))
		{
			ans = function(str, cpy ,start-1 , end-1  , dp);
		}
		else
		{
			ans  = Math.min(
					function(str , cpy , start-1 , end , dp)
					,function(str , cpy , start , end-1 , dp))+1;
		}

		return dp[start][end] = ans;
	}
}