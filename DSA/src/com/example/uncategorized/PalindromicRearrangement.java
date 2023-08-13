package com.example.uncategorized;
import java.util.* ;
import java.io.*; 
 

public class PalindromicRearrangement {

	public static boolean palidromicRearrangement(int n, String str) {
		// Write your code here.
		Map<Character , Integer> map = new HashMap<>();
		for(char ch : str.toCharArray()) map.put(ch , map.getOrDefault(ch,0)+1);
	
	int odd = 0;
	
	for(Map.Entry<Character,Integer> m1 : map.entrySet())
	{
		if(m1.getValue()%2==1) odd++;
	}

	if(odd>1) return false;
	return true;
	}
}
