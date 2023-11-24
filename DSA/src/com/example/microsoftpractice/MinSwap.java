package com.example.microsoftpractice;

import java.util.*;

// https://practice.geeksforgeeks.org/problems/minimum-swaps/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

class SwapPair
{
	int nums;
	int pos;

	SwapPair(int nums , int pos)
	{
		this.nums=nums;
		this.pos=pos;
	}
}

public class MinSwap
{
	//Function to find the minimum number of swaps required to sort the array.
	public int minSwaps(int nums[])
	{
		// Code here
		// 2 8 5 4
		//2,0 | 4,3 | 5,2 | 8,1
		List<SwapPair> list = new ArrayList<>();
		for(int i=0;i<nums.length;i++) list.add(new SwapPair(nums[i] , i ));

		Collections.sort(list, (a , b) -> a.nums - b.nums);

		int count=0;
		for(int i = 0 ; i<nums.length;i++)
		{
			SwapPair p1 = list.get(i); // 4,3
			if(p1.pos == i) continue;
			count++; // 1
			list.set(i , list.get(p1.pos)); 
			list.set(p1.pos , p1);
			i--;
		}

		return count;
	}

}