package CodingNinjaPOTD;

// https://www.codingninjas.com/studio/problems/palindrome-partitioning_873266

public class PalindromePartitioning2_Hard1609 {

	public static void main(String[] args)
	{
		palindromePartitioning("aabbc");
		System.out.println(min);
	}

	static int min = Integer.MAX_VALUE;
	public static int palindromePartitioning(String str) {
		// Write your code here
		min = Integer.MAX_VALUE;
		palindrome(str , 0);
		return min == Integer.MAX_VALUE?-1:min-1;
	}

	static void palindrome(String str , int count)
	{
		if(str.length() == 0)
		{
			min = Math.min(min,count);
			return;
		}

		for(int i=0 ; i<str.length() ; i++)
		{
			if(isPalindrome(str.substring(0 , i+1)))
			{
				palindrome(str.substring(i+1) , count+1);
			}
		}
	}

	static boolean isPalindrome(String str)
	{
		int start = 0;
		int end = str.length()-1;

		while(start<end)
		{
			if(str.charAt(start) != str.charAt(end)) return false;
			start++;
			end--;
		}
		return true;
	}
}