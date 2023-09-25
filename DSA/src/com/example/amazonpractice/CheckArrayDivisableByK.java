package com.example.amazonpractice;

// https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
// TC -> N*N!

public class CheckArrayDivisableByK {
	static boolean ans = false;
	public static void main(String[] args)
	{
		boolean res = canArrange(new int[] {1,2,3,4,5,10,6,7,8,9}, 5);
		System.out.println(res);
	}
	public static boolean canArrange(int[] arr, int k) {
		ans = false;
		int sum = 0;
		int n = arr.length;
		if(n%2 == 1) return false;

		for(int i=0;i<n;i++)
		{
			sum += arr[i];
		}
		if(sum%k != 0) return false;
		int div = n/2;
		function(0 , 0 , div , 0 , k , arr , new boolean[n] , n );
		return ans;
	}

	static void function(int count, int curr , int div , int sum , int k , int[] arr , boolean[] isVisited , int n)
	{
		if(curr == div-1)
		{
			ans = true;
			return;
		}

		if(count>2) return;

		if(count == 2 && sum%k == 0)
		{
			function(0 , curr+1,div , 0 , k , arr , isVisited , n);
		}

		for(int i=0;i<n;i++)
		{
			if(! isVisited[i])
			{
				isVisited[i] = true;
				function(count+1 , curr ,div , sum+arr[i] , k , arr , isVisited , n);
				if(ans) return;
				isVisited[i] = false;
			}
		}

	}
}