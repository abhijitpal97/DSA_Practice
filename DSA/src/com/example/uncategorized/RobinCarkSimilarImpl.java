package com.example.uncategorized;

import java.util.ArrayList;

public class RobinCarkSimilarImpl
{
	//Can generate hashcode if needed as per RK Algo
	ArrayList<Integer> search(String pat, String S)
	{
		// your code here
		int n = S.length(); //6
		int m = pat.length(); //3
		ArrayList<Integer> list = new ArrayList<>();

		for(int i = 0; i<n-m+1 ; i++)
		{
			String str = S.substring(i , i+m);
			if(pat.equals(str)) list.add(i+1);
		}

		if(list.isEmpty()) 
		{
			list.add(-1);
		}
		return list;
	}
}
