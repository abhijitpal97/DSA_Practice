package com.example.amazonpractice;

// https://practice.geeksforgeeks.org/problems/minimum-swaps-required-to-group-all-1s-together2451/1

public class MinSwapGroupAllOnes {

	public static void main(String[] args)
	{
		int res = minSwaps(new int[] {1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1}, 15);
		System.out.println(res);
	}
	// Function for finding maximum and value pair
	public static int minSwaps(int arr[], int n) {
		int one =0;

		for(int i=0;i<n;i++) 
		{
			if(arr[i] == 1) one++;
		}

		if(one == 0) return -1;

		int currOne = 0;
		int window = 0;
		int maxOne = 0;
		int start = 0;
		int end = 0;

		while(end<n)
		{
			if(arr[end] == 1) currOne++;

			window = end-start+1;
			while(window>one)
			{
				if(arr[start]== 1) currOne--;
				start++;
				window = end-start+1;
			}

			if(window == one) maxOne = Math.max(maxOne , currOne);
			end++;
		}

		return one-maxOne;
	}
}
