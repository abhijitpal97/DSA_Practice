package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/shortest-palindrome_3118979

public class ShortestPalindrome_Moderate2001 {

	public static String findShortestPalindrome(String str) {
		// Write your code here.
		int n = str.length();
		String s1 = "";
		int longest = 0;
		int index = 0;
		for(int i=0;i<n;i++)
		{
			s1 += str.charAt(i);
			if(isPalin(s1))
			{
				if(longest<s1.length())
				{
					longest = s1.length();
					index = i; 
				}
			}
		}
		String s2 = "";
		if(longest == 0)
		{
			s2 = str.substring(1);
			s2 = reverse(s2);
			return s2+str.charAt(0)+str.substring(1);
		}
		else
		{
			s2 = str.substring(index+1);
			s2 = reverse(s2);
			return s2+str.substring(0 , index+1)+str.substring(index+1); 
		}
	}

	static boolean isPalin(String s1)
	{
		int start = 0;
		int end = s1.length()-1;
		while(start<end)
		{
			if(s1.charAt(start) != s1.charAt(end)) return false;
			start++;
			end--;
		}
		return true;
	}

	static String reverse(String s1)
	{
		String s2 = "";
		for(int i = s1.length()-1 ; i>=0 ; i--)
		{
			s2 += s1.charAt(i);
		}
		return s2;
	}

}
