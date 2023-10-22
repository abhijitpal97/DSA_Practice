package com.example.amazonpractice;

// https://www.codingninjas.com/studio/problems/count-set-bits_1112627

public class CountSetBits 
{
	public static int countSetBits(int n) 
	{
		//    Write your code here.
		int sum = 0;
		for(int i = 1; i<=n ; i++)
		{
			String str = Integer.toBinaryString(i);
			//String str = String.valueOf(temp);
			int count =  0;
			for(char ch : str.toCharArray())
			{
				if(ch == '1') count++;
			}

			sum = (sum+count)%1000000007;
		}

		return sum%1000000007;

	}
}