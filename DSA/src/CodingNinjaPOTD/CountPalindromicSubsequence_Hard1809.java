package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://practice.geeksforgeeks.org/problems/count-palindromic-subsequences/1
public class CountPalindromicSubsequence_Hard1809 {

	public static void main(String[] args)
	{
		int res = countPalinSubseq("aba");
		System.out.println(res);
	}

	public static int countPalinSubseq(String s) {
		// Write your code here.

		Set<String> set = new HashSet<>();
		getAllsubsequence(s , "" , 0 , s.length() , set);
		System.out.println(set);

		return set.size()%1000000007;
	}

	static void getAllsubsequence(String str , String s, int index , int n , Set<String> set)
	{

		if(s.length() != 0 && isPalindromic(s)) set.add(s);
		if(index == n) return;

		char ch = str.charAt(index);

		getAllsubsequence(str , s+ch , index+1 , n , set);
		getAllsubsequence(str , s , index+1 , n , set);

	}

	static boolean isPalindromic(String str)
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
