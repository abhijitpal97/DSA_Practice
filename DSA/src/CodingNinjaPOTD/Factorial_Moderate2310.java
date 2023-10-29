package CodingNinjaPOTD;

// https://practice.geeksforgeeks.org/problems/factorials-of-large-numbers2508/1

public class Factorial_Moderate2310 {
	public static void factorial(int n) {
		// Write your code here
		if(n <= 2) 
		{
			System.out.println(n);
			return;
		}

		long[] dp = new long[n+1];
		dp[1] = 1;
		dp[2] = 2;

		for(int i = 3;i<=n ; i++)
		{
			dp[i] = i*dp[i-1];
		}

		System.out.println(dp[n]);
	}
}
