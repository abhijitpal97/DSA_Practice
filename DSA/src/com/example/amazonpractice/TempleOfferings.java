package com.example.amazonpractice;

// https://practice.geeksforgeeks.org/problems/temple-offerings2831/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

public class TempleOfferings{
	int offerings(int N, int arr[]){
		// code here

		int[] left = new int[N];
		int[] right = new int[N];
		int offer = 1;

		left[0]=offer;
		right[N-1] = offer;

		for(int i=1;i<N;i++)
		{
			if(arr[i-1]<arr[i])
			{
				offer++;
				left[i] = offer;
			}
			else
			{
				offer = 1;
				left[i] = offer;
			}
		}

		offer = 1;

		for(int i = N-2; i>=0 ; i--)
		{
			if(arr[i]>arr[i+1])
			{
				offer++;
				right[i] = offer;
			}
			else
			{
				offer = 1;
				right[i]=offer;
			}
		}

		int ans=0;
		for(int i=0;i<N;i++)
		{
			ans += Math.max(left[i] ,right[i]);
		}

		return ans;
	}
}