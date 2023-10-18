package com.example.oracle;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/armstrong-number_1462443

public class ArmstrongNumber 
{
	public static boolean isArmstrong(int num)
	{
		// wrtie your code here;
		String str = String.valueOf(num);

		int len = str.length();
		int sum = 0;

		for(int i=0;i<len;i++)
		{
			int temp = str.charAt(i) - '0';

			sum += (int)Math.pow(temp , len);
		}

		return sum == num;
	}
}

