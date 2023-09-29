package com.example.amazonpractice;

// https://leetcode.com/problems/rotate-array/description/

public class RotateArray {
	public void rotate(int[] nums, int k) {
		int n = nums.length;
		k = k%n;
		int[] p1 = new int[n-k];
		int[] p2 = new int[k];
		int index = 0;
		for(int i=0;i<n-k;i++) 
		{
			p1[index] = nums[i];
			index++;
		}
		index = 0;
		for(int i=n-k;i<n;i++)
		{
			p2[index] = nums[i];
			index++;
		}

		index = 0;
		for(int i=0;i<p2.length;i++)
		{
			nums[index] = p2[i];
			index++;
		}
		for(int i = 0;i<p1.length;i++)
		{
			nums[index] = p1[i];
			index++;
		}
	}
}