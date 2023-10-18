package com.example.oracle;

// https://www.codingninjas.com/studio/problems/check-if-one-string-is-a-rotation-of-another-string_1115683

public class CyclicRotation {
	public static int isCyclicRotation(String p, String q)  {
		int m = q.length();

		for(int i=0;i<m;i++)
		{
			if(p.charAt(0) == q.charAt(i))
			{
				if(p.equals(q.substring(i)+q.substring(0,i))) return 1;                
			}
		}
		return 0;


	}
}