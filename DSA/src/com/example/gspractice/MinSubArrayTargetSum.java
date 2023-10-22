package com.example.gspractice;
import java.util.*;

// https://www.codingninjas.com/studio/problems/minimum-subarray-with-required-sum_696460

public class MinSubArrayTargetSum 
{
	public static ArrayList<Integer> minSubarray(ArrayList<Integer> arr, int n, int x) 
	{
		// Write your code here
		int curr = 0;
		int min = Integer.MAX_VALUE;
		ArrayList<Integer> res  = new ArrayList<>();
		List<Integer> list  = new ArrayList<>();
		for(int i = 0;i<n; i++)
		{
			curr += arr.get(i);
			list.add(arr.get(i));
			while(curr>x)
			{
				if(min>list.size()) 
				{
					res.clear();
					min = list.size();
					for(int m : list) res.add(m);
				}
				curr -=list.get(0);
				list.remove(0);

			}			
		}

		return res;
	}
}
