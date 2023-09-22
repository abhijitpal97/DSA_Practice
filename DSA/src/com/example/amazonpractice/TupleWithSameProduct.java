package com.example.amazonpractice;

import java.util.Arrays;

public class TupleWithSameProduct {

	public static void main(String[] args)
	{
		int res = tupleSameProduct(new int[] {2,3,6,4});
		System.out.println(res);
	}

	public static int tupleSameProduct(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		int count = 0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i==j) continue;
				int mul = nums[i]*nums[j];
				if(possible(nums , mul , i , j)) count++;
			}
		}

		return count;
	}

	static boolean possible(int[] nums , int mul , int i , int j)
	{
		int start=0;
		int end = nums.length-1;

		while(start<end)
		{
			int curr = nums[start] * nums[end];
			if(start == i || start == j) start++;
			else if(end == i || end == j) end--;
			else if(curr == mul) return true;
			else if(mul>curr) end--;
			else start++;
		}

		return false;
	}
}