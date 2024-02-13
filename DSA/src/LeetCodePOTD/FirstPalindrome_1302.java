package LeetCodePOTD;

// https://leetcode.com/problems/find-first-palindromic-string-in-the-array/

public class FirstPalindrome_1302 {
	public String firstPalindrome(String[] words) {
		for(String str : words)
		{
			if(isPalindrome(str)) return str;
		}
		return "";
	}

	boolean isPalindrome(String str)
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