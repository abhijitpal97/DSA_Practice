package CodingNinjaPOTD;

public class FibonacciSum_Moderate2308 {

	public static void main(String[] args)
	{
		int s1 = fiboSum(0, 5);
		System.out.println(s1);
	}

	public static int fiboSum(int n , int m) {
		// Write your code here.
		int sum = 0;
		int upper = Math.max(n,m);
		int lower = Math.min(n,m);
		int[] dp = new int[upper+1];
		dp[0] = 0;
		dp[1] = 1;
		if(lower<2) sum = 1;
		for(int i = 2 ; i<=upper ; i++)
		{
			dp[i] = dp[i-1]+dp[i-2];
			if(i>=lower) sum += dp[i];
		}
		return sum;

	}

}