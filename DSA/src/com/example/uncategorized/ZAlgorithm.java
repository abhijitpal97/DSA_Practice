package com.example.uncategorized;

// https://www.codingninjas.com/studio/problems/z-algorithm_1112619

public class ZAlgorithm {

	public static void main(String[] args)
	{
		int count = zAlgorithm("aabbbb", "bb", 6, 2);
		System.out.println(count);
	}
	public static int zAlgorithm(String s, String p, int n, int m) {
		// Write your code here
		int count = 0;
		for(int i=0; i<=n-m;i++)
		{
			String str = s.substring(i);
			if(str.indexOf(p)==0)
			{
				System.out.println(str);
				count++;
			}
		}
		return count;

	}

}