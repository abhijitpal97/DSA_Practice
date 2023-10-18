package com.example.oracle;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/jumping-numbers_1069220

public class JumpingNumbers 
{
	public static ArrayList<Integer> jumpingNumbers(int n) 
    {
		// Write your code here.
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		
		for(int i=1;i<=n;i++)
		{
			if(isCheck(i)) list.add(i);
		}
		return list;
	}

	static boolean isCheck(int i)
	{
		String str = String.valueOf(i);
		if(str.length()==1) return true;

		
		for(int j=1;j<str.length();j++)
		{
			int prev = str.charAt(j-1) - '0';
			int curr = str.charAt(j) - '0';
			//System.out.println(prev + " - - "+curr);
			if((prev+1 !=curr) && (prev-1 != curr)) return false;
		}

		return true;
	}
}