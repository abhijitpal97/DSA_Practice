package StriverSheet175AndLoveBabbar450;
// https://www.geeksforgeeks.org/problems/palindromic-patitioning4845

public class PalindromicPartionCuts{
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args)
	{
		int res = palindromicPartition("ab");
		System.out.println(res);
	}
	static int palindromicPartition(String str)
	{
		// code here
		min = Integer.MAX_VALUE;
		function(str  , 0);
		return min;
	}

	static void function(String str , int count)
	{
		if(str.length() == 0)
		{
			min = Math.min(min , count);
			return;
		}

		for(int i = 0; i<str.length();i++)
		{
			String curr = str.substring(0 , i+1);
			if(isPalindrome(curr))
			{
				function(str.substring(i+1) , count+1);
			}
		}
	}

	static boolean isPalindrome(String str)
	{
		int start = 0;
		int end = str.length()-1;

		while(start < end)
		{
			if(str.charAt(start) != str.charAt(end)) return false;

			start++;
			end--;
		}

		return true;
	}

	// DP - Memorization

	static int palindromicPartitionMemo(String str)
	{
		// code here
		int n = str.length();
		Integer[][] dp = new Integer[n+1][n+1];

		return helper(str , 0, n-1 , dp);

	}


	static int helper(String str , int start , int end , Integer[][] dp)
	{
		if(start>end) return 0;
		if(isPalindrome(str , start , end))  return 0;

		int ans = Integer.MAX_VALUE;

		if(dp[start][end] != null) return dp[start][end];

		for(int i=start;i<end;i++)
		{
			int temp = 1+helper(str ,start, i , dp)+helper(str ,i+1 , end , dp);

			ans = Math.min(ans,temp);
		}


		return dp[start][end] = ans;

	}


	static boolean isPalindrome(String s, int i, int j){

		if(i==j)

			return true;

		if(i>j)

			return true;

		while(i<j){

			if(s.charAt(i)!=s.charAt(j))

				return false;

			i++; j--;

		}

		return true;

	}
}