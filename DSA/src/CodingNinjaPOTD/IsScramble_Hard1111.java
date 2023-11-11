package CodingNinjaPOTD;

import java.util.*;

// https://leetcode.com/problems/scramble-string/

public class IsScramble_Hard1111 {

	// Recursive
	public boolean isScramble(String s1, String s2) {
		if(s1.equals(s2)) return true;
		if(s1.length() != s2.length()) return false;

		return helper(s1,s2);
	}

	boolean helper(String s1 , String s2)
	{
		if(s1.equals(s2)) return true;
		if(s1.length() <= 1) return false;

		int n = s1.length();
		boolean res = false;

		for(int i=1;i<n;i++)
		{
			boolean swap = helper(s1.substring(0,i) ,  s2.substring(n-i)) && helper(s1.substring(i) ,  s2.substring(0 , n-i));
			boolean notSwap = helper(s1.substring(0,i) ,  s2.substring(0,i)) && helper(s1.substring(i) ,  s2.substring(i));

			if(swap || notSwap)
			{
				res = true;
				break;
			}
		}


		return res;
	}

	//Memorization
	Map<String, Boolean> map = new HashMap<>();
	public boolean isScrambleMemo(String s1, String s2) {
		if(s1.equals(s2)) return true;
		if(s1.length() != s2.length()) return false;

		return helperMemo(s1,s2);
	}

	boolean helperMemo(String s1 , String s2)
	{
		if(s1.equals(s2)) return true;
		if(s1.length() <= 1) return false;

		int n = s1.length();
		boolean res = false;

		String key = s1+'_'+s2;

		if(map.containsKey(key)) return map.get(key);
		for(int i=1;i<n;i++)
		{
			boolean swap = helperMemo(s1.substring(0,i) ,  s2.substring(n-i)) && helperMemo(s1.substring(i) ,  s2.substring(0 , n-i));
			boolean notSwap = helperMemo(s1.substring(0,i) ,  s2.substring(0,i)) && helperMemo(s1.substring(i) ,  s2.substring(i));

			if(swap || notSwap)
			{
				res = true;
				break;
			}
		}

		map.put(key , res);
		return res;
	}
}