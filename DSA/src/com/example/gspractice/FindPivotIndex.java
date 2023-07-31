package com.example.gspractice;

import java.util.*;

public class FindPivotIndex {
	public static void main(String[] args)
	{
		int res = pivotIndex(new int[] {-1,-1,0,1,1,0});
		System.out.println(res);
	}
	public static int pivotIndex(int[] nums) {
		int sum = 0;
		for(int i = 0;i<nums.length;i++) sum += nums[i];

		int curr = 0;
		for(int i = 0 ; i<nums.length ; i++)
		{
			if((sum-nums[i])%2 == 0 && (sum-nums[i])/2 == curr) return i;
			curr +=nums[i];
		}
		return -1;
	}
}