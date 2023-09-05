package com.example.amazonpractice;
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class ChocholateFeast {

	public static void main(String[] args)
	{
		ArrayList<Integer> res = chocolateFest(new ArrayList<>(Arrays.asList(1,3,5,6,4,3)), 9);
		System.out.println(res);
	}

	public static ArrayList<Integer> chocolateFest(ArrayList<Integer> choco, int x) {

		// Write your code here.
		int sum = 0 ;
		int start = 0;
		int end = 0 ;
		int n = choco.size();
		int startIndex= 0;
		int length = Integer.MAX_VALUE;

		while(end<n)
		{
			sum += choco.get(end);
			if(sum > x)
			{
				if(end-start<length)
				{
					startIndex = start;
					length = end-start;
				}

				while(start<end && sum>=x)
				{
					sum -= choco.get(start);
					start++;

					if(sum>x && end-start<length)
					{
						startIndex = start;
						length = end-start;
					}
				}
			}
			end++;
		}

		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0 ; i<=length ; i++)
		{
			list.add(choco.get(startIndex+i));
		}

		return list;
	}
}